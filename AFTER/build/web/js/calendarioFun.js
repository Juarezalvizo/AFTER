/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */


const getURL = (year) =>
  `https://nolaborables.com.ar/api/v2/feriados/${year}?formato=mensual&incluir=opcional`;
const maxYear = 2019;

const months = [
  "Enero",
  "Febrero",
  "Marzo",
  "Abril",
  "Mayo",
  "Junio",
  "Julio",
  "Agosto",
  "Septiembre",
  "Octubre",
  "Noviembre",
  "Diciembre"
];

const days = [
  "Lunes",
  "Martes",
  "Miercoles",
  "Jueves",
  "Viernes",
  "Sabado",
  "Domingo"
];
const numDays = (month, year) => new Date(year, month + 1, 0).getDate();
const firstDay = (month, year) => new Date(year, month, 1).getDay();
const dayOfWeek = (day, month, year) => new Date(year, month, day).getDay();

const Holiday = ({ day, tipo, motivo, original, opcional }) => {
  return (
    <div>
      <h3>{motivo}</h3>
      <p className="type">
        {tipo}
        <span className="tag">feriado</span>
        {opcional && <span className="opt">opcional</span>}
        {tipo === "trasladable" && <span className="opt">{original}</span>}
      </p>
    </div>
  );
};

const Day = ({ day, holiday, isToday, onClick }) => {
  if (!day)
    return (
      <li className="blank" dangerouslySetInnerHTML={{ __html: "&nbsp;" }}></li>
    );

  let css = holiday ? `holiday ${holiday.tipo} ` : "";
  css += isToday ? "today" : "";
  return (
    <li className={css} onClick={() => onClick(holiday)}>
      {day || "."}
    </li>
  );
};

const CurrentDay = ({ year, month, day }) => {
  const weekDay = dayOfWeek(day, month, year);
  return (
    <section className="current-day">
      <h3>{days[!weekDay ? 6 : weekDay - 1]}</h3>
      <p className="day">{day}</p>
    </section>
  );
};

const Header = ({ current, onChange }) => {
  const year = current.getFullYear();
  const month = current.getMonth();

  const onLeftClicked = () => {
    const nextMonth = month - 1;
    const moveYear = nextMonth < 0;
    onChange(moveYear ? 11 : nextMonth, moveYear ? year - 1 : year);
  };

  const onRightClicked = () => {
    const nextMonth = month + 1;
    const moveYear = nextMonth > 11;
    onChange(moveYear ? 0 : nextMonth, moveYear ? year + 1 : year);
  };

  const hideLeft = year === 2011 && month === 0;
  const hideRight = year === maxYear && month === 11;

  return (
    <div className="calendar-header">
      {!hideLeft && <a className="left" onClick={onLeftClicked}></a>}
      <h2>
        {months[month]} {year}
      </h2>
      {!hideRight && <a className="right" onClick={onRightClicked}></a>}
    </div>
  );
};

class Calendar extends React.Component {
  constructor(props) {
    super(props);

    const today = new Date();
    this.state = {
      loading: true,
      year: today.getFullYear(),
      month: today.getMonth(),
      today,
      holidays: [],
      allHolidays: {}
    };
  }

  componentDidMount() {
    this.loadHolidays();
  }

  setStateHolidays(data) {
    let newState = { holidays: data };
    const holiday = this.getHoliday(
      data,
      this.state.month,
      this.state.today.getDate()
    );

    if (holiday) {
      newState = { ...newState, selected: { holiday, day: this.state.day } };
    }

    this.setState(newState);
  }

  loadHolidays() {
    const cacheHolidays = this.state.allHolidays[this.state.year];
    if (cacheHolidays) {
      this.setStateHolidays(cacheHolidays);
      return;
    }

    this.setState({ loading: true });
    axios.get(getURL(this.state.year)).then(({ data }) => {
      let yholidays = data.map((month) =>
        Object.keys(month).reduce(
          (days, day) => ({
            ...days,
            [day]: Array.isArray(month[day]) ? month[day][0] : month[day]
          }),
          {}
        )
      );

      this.setState(
        {
          loading: false,
          allHolidays: {
            ...this.state.allHolidays,
            [this.state.year]: yholidays
          }
        },
        () => this.setStateHolidays(yholidays)
      );
    });
  }

  getHoliday(holidays, month, day) {
    return _.get(holidays, `[${month}][${day}]`);
  }

  onChange(month, year) {
    const day = 1;
    const today = new Date(year, month, day);
    this.setState({ year, month, day, today }, () => this.loadHolidays(year));
  }

  getDays() {
    const { loading, holidays, month, year } = this.state;
    const days = numDays(month, year);
    let fDay = firstDay(month, year) - 1;
    fDay = fDay === -1 ? 6 : fDay;
    return _.times(fDay, _.constant(null)).concat(_.times(days, (i) => i + 1));
  }

  render() {
    const { month, loading, holidays, year, today, selected } = this.state;
    const current = (selected && selected.day) || today.getDate();
    const getHoliday = (day) =>
      !loading ? _.get(holidays, `[${month}][${day}]`) : null;

    const isToday = (day) =>
      day === new Date().getDate() && month === new Date().getMonth()
        ? true
        : false;

    return (
      <div className="container">
        <CurrentDay day={current} month={month} year={year} />
        <section className="calendar">
          {loading ? (
            <div className="loading">Cargando feriados...</div>
          ) : (
            <div>
              <Header
                current={today}
                onChange={(m, y) => this.onChange(m, y)}
              />
              <ul>
                {days.map((day) => (
                  <li>{day.substring(0, 2)}</li>
                ))}
                {this.getDays().map((day) => (
                  <Day
                    day={day}
                    holiday={getHoliday(day)}
                    isToday={isToday(day)}
                    onClick={(holiday) =>
                      this.setState({ selected: { holiday, day } })
                    }
                  />
                ))}
              </ul>
            </div>
          )}
        </section>
        <section
          className={
            "holiday " + (selected && selected.holiday ? "active" : "")
          }
        >
          {selected && selected.holiday && <Holiday {...selected.holiday} />}
        </section>
      </div>
    );
  }
}

ReactDOM.render(<Calendar />, document.getElementById("mount"));
