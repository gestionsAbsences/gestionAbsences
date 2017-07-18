import React, { Component } from 'react';

import './popup.css';

class Popup extends Component {

  constructor(props){
      super(props); // Récupère le Props du parent
      this.props=props;
      this.state={ // Définition des propriétés du State
        isHidden: this.props.cacher
      };
  }

  trtOk = () => {
    this.setState({
      isHidden: true
    });
    if (this.props.retour) {this.props.retourAccueil()}
  }

  render() {
    return (
      <div className="popup panel panel-default" hidden={this.state.isHidden}>
        <div className="panel-heading">
          <h3 className="panel-title">{this.props.titre}</h3>
        </div>
        <div className="panel-body">
          <p>{this.props.message}</p>
          <input className="btn btn-primary btn-block" type="submit" value="Ok" onClick={this.trtOk} />
        </div>
      </div>
    )
  }
}

export default Popup;
