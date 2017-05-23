import React, { Component } from 'react';

import '../../Bootstrap/dist/css/sb-admin-2.css'
import './nouvelledemande.css';

class NouvelleDemande extends Component {
  render() {
    return (
      <div className="">
        <div className="col-md-6">
            <div className="form-group">
                <label>Selects</label>
                <select className="form-control">
                    <option>1</option>
                    <option>2</option>
                    <option>3</option>
                    <option>4</option>
                    <option>5</option>
                </select>
            </div>
            <div className="form-group">
                <label>Text Input with Placeholder</label>
                <input className="form-control" placeholder="Enter text" />
            </div>
            <div className="form-group">
                <label>Text Input with Placeholder</label>
                <input className="form-control" placeholder="Enter text" />
            </div>
          </div>
          <div className="col-md-6">
            <div className="form-group">
                <label>Text Input with Placeholder</label>
                <input className="form-control" placeholder="Enter text" />
            </div>
            <div className="form-group">
                <label>Text Input with Placeholder</label>
                <input className="form-control" placeholder="Enter text" />
            </div>
            <div className="form-group">
                <label>Text Input with Placeholder</label>
                <input className="form-control" placeholder="Enter text" />
            </div>
            <div className="form-group">
                <label>Text Input with Placeholder</label>
                <input className="form-control" placeholder="Enter text" />
            </div>
          </div>
          <div className="col-md-12 centered">
              <button type="button" className="btn btn-primary">Default button</button>
          </div>
      </div>
    );
  }
}

export default NouvelleDemande;
