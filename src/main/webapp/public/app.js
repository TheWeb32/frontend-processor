var Outcome = React.createClass({

  getInitialState: function() {
    return {display: true };
  },
  getRelatedOutcome() {
    var self = this;
    
  },
  render: function() {

    if (this.state.display==false) return null;
    else return (
      <tr>
          <td>{this.props.outcome.name}</td>
          <td>{this.props.outcome.price}</td>
      </tr>
    );
  }
});

var OutcomeTable = React.createClass({

  render: function() {

    var rows = [];
    this.props.outcomes.forEach(function(outcome) {
      rows.push(
        <Outcome outcome={outcome} key={outcome.name} />);
    });

    return (
      <table className="table table-striped">
          <thead>
              <tr>
                  <th>Name</th>
                  <th>Price</th>
              </tr>
          </thead>
          <tbody>{rows}</tbody>
      </table>
    );
  }
});

var OutcomeContainer = React.createClass({

  loadOutcomeFromServer: function() {

    var self = this;
    $.ajax({
        url: "outcomes/findByMarketId/" + self.props.relatedMarketId,
      }).then(function(data) {
        self.setState({ outcomes: data });
      });

  },

  getInitialState: function() {
    return { outcomes: [] };
  },

  componentDidMount: function() {
    this.loadOutcomeFromServer();
  },

  render() {
    return ( <OutcomeTable outcomes={this.state.outcomes} /> );
  }
});

var Market = React.createClass({

  getInitialState: function() {
    return {display: true };
  },
  getRelatedOutcome: function() {
    var self = this;
    ReactDOM.render(<OutcomeContainer relatedMarketId={self.props.market.marketId} />, document.getElementById('root') );
  },
  render: function() {

    if (this.state.display==false) return null;
    else return (
      <tr>
          <td>{this.props.market.name}</td>
          <td>{this.props.market.displayed}</td>
          <td>
            <button className="btn btn-info" onClick={this.getRelatedOutcome}>Related Outcome</button>
          </td>
      </tr>
    );
  }
});

var MarketTable = React.createClass({
  render: function() {

    var rows = [];
    this.props.markets.forEach(function(market) {
      rows.push(
        <Market market={market} key={market.name} />);
    });

    return (
      <div>
	      <table className="table table-striped">
	          <thead>
	              <tr>
	                  <th>Name</th>
	                  <th>Displayed</th>
	              </tr>
	          </thead>
	          <tbody>{rows}</tbody>
	      </table>
      </div>
    );
  }
});

var MarketContainer = React.createClass({

  loadMarketsFromServer: function() {

    var self = this;
    $.ajax({
        url: "markets/findByEventId/" + self.props.relatedEventId,
      }).then(function(data) {
        self.setState({ markets: data });
      });

  },

  getInitialState: function() {
    return { markets: [] };
  },

  componentDidMount: function() {
    this.loadMarketsFromServer();
  },

  render() {
    return ( <MarketTable markets={this.state.markets} /> );
  }
});

var Event = React.createClass({

  getInitialState: function() {
    return {display: true };
  },
  getRelatedMarkets() {
    var self = this;
    ReactDOM.render(<MarketContainer relatedEventId={self.props.event.eventId} />, document.getElementById('root') );
  },
  render: function() {

    if (this.state.display==false) return null;
    else return (
      <tr>
          <td>{this.props.event.name}</td>
          <td>{this.props.event.category}</td>
          <td>{this.props.event.subCategory}</td>
          <td>
            <button className="btn btn-info" onClick={this.getRelatedMarkets}>Related Market</button>
          </td>
      </tr>
    );
  }
});

var EventTable = React.createClass({

  render: function() {

    var rows = [];
    this.props.events.forEach(function(event) {
      rows.push(
        <Event event={event} key={event.name} />);
    });

    return (
	      <table className="table table-striped">
	          <thead>
	              <tr>
	                  <th>Name</th>
	                  <th>Category</th>
	                  <th>Subcategory</th>
	              </tr>
	          </thead>
	          <tbody>{rows}</tbody>
	      </table>
    );
  }
});

var EventContainer = React.createClass({

  loadEventsFromServer: function() {
    var self = this;
    $.ajax({
      url: "events/findAll",
    }).then(function(data) {
      self.setState({ events: data });
    });

  },
  
  getInitialState: function() {
    return { events: [] };
  },

  componentDidMount: function() {
    this.loadEventsFromServer();
  },

  render() {
    return ( <EventTable events={this.state.events} /> );
  }
});

ReactDOM.render(<EventContainer />, document.getElementById('root') );
