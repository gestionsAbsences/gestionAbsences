import React, { Component } from 'react';

import Menu from './Menu.js';

import './bardenav.css';

class BarDeNav extends Component {

  constructor (props) {
    super(props); // Récupère le Props du parent
    this.props=props;
  }

  render() {
    return (
      <div className="bardenav menudesktop">
        <div className="voffsetnav">&nbsp;</div>
        <div className="affix panel-group col-xs-0 col-sm-0 col-md-2 col-lg-2">
          <Menu cas={1}
                role={this.props.role} />
        </div>
      </div>
    );
  }
}

export default BarDeNav;
