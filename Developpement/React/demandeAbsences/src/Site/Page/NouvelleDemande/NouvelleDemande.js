import React, { Component } from 'react';

import axios from 'axios'

import '../../Bootstrap/dist/css/sb-admin-2.css'
import './nouvelledemande.css';

class NouvelleDemande extends Component {

    constructor(props) {
        super(props);
        this.state = {
            types: [],
            employes: []
        }
    }

    componentDidMount() {
         axios.get('http://localhost:8080/type/listeService/')
            .then(res => {
                console.log(res.data);
                this.setState({types: res.data});
        });

        axios.get('http://localhost:8080/emp/getEmploye?nom=perez')
           .then(res => {
               console.log(res.data);
               this.setState({employe: res.data});
       });
    }

  render() {
    return (
      <div className="">

        <div className="voffset">&nbsp;</div>


        <div className="col-md-4 col-md-offset-1">
            <div className="form-group">
                <label>Type d absence</label>
                <select className="form-control">
                {
                    this.state.types.map(
                      (type, i) =>
                      <option key={i}>
                        {type.nom}
                      </option>
                      )
                    }
                </select>
            </div>
            <div className="form-group">
                <label>Date de début</label>
                <input className="form-control" placeholder="Début" />
            </div>
            <div className="form-group">
                <label>Date de fin</label>
                <input className="form-control" placeholder="Fin" />
            </div>
        </div>


        <div className="col-md-4 col-md-offset-2">
            <div className="form-group">
                <label>Congés payés</label>
                <input className="form-control" placeholder="Congés payés" />
            </div>
            <div className="form-group">
                <label>RTT</label>
                <input className="form-control" placeholder="RTT" />
            </div>
            <div className="form-group">
                <label>Repos compensateur</label>
                <input className="form-control" placeholder="Repos compensateur" />
            </div>
            <div className="form-group">
                <label>Valideur</label>
                <input className="form-control" placeholder="Valideur" />
            </div>
        </div>


        <div className="col-md-1 col-md-offset-2">
              <button type="button" className="btn btn-primary">Soumettre</button>
        </div>
        <div className="col-md-1">
              <button type="button" className="btn btn-primary">Annuler</button>
        </div>
      </div>
    );
  }
}

export default NouvelleDemande;
