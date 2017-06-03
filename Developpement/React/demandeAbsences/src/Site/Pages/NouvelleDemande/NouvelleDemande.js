import React, { Component } from 'react';
import axios from 'axios';

import './nouvelledemande.css';

let nom="PEREZ";

let responsable="GRUMELON Gérald";

class NouvelleDemande extends Component {

      constructor(props) {
          super(props);
          this.state = {
              nomResp:"",
              prenomResp:"",
              nbCa:0,
              nbRtt:0,
              nbRc:0,
              types: []
        }
      }

            componentDidMount() {
                 axios.get('http://localhost:8080/emp/getEmploye?nom='+nom)
                    .then(res => {
                        this.setState({
                          nom: res.data[0].nomResp,
                          prenom: res.data[0].prenomResp,
                          nbCa: res.data[0].nbCa,
                          nbRtt: res.data[0].nbRtt,
                          nbRc: res.data[0].nbRc
                      });
                });
                 axios.get('http://localhost:8080/type/listeTypeAbsence')
                    .then(res => {
                        this.setState({
                          types: res.data
                      });
                });
      }

  render() {
    return (
      <div>
        <div className="voffsetpos">&nbsp;</div>   {/*1   Cosmétique Ajout d'une marge au dessus du formulaire réglable via le css voffsetpos */}{/*1    fin */}
        <div className="panel panel-default">   {/*2   Formulaire */}
          <div className="panel-heading">   {/*3   Titre de Formulaire */}
            <h3 className="panel-title">Nouvelle demande</h3>
          </div>   {/*3   fin */}
          <div className="panel-body">   {/*4   Contenu Formulaire */}
            <div className="voffsethaut">&nbsp;</div>   {/*5   Cosmétique Ajout d'une marge au dessus du contenu du formulaire réglable via le css voffsethaut */}{/*5   fin */}
            <div className="row">
              <div className="col-md-4 col-md-offset-1">   {/*6   Formulaire Partie gauche */}
                <div className="form-group">   {/*7   Un des champs select du Formulaire */}
                  <label>Type d'absence</label>                    {/*'*/}{/* Factice Pour rectifier bug d'affichage sur Atom */}
                  <select className="form-control">
                    {this.state.types.map(
                      (type, i) =>
                      <option key={i}>{type.nom}</option>
                    )}
                  </select>
                </div>   {/*7   fin */}
                <div className="form-group">   {/*9   Un des champ de saisie de type texte */}
                  <label>Date de début</label>
                  <input type="date" className="form-control" placeholder="Début" />
                  </div>   {/*9   fin */}
                <div className="form-group">
                  <label>Date de fin</label>
                  <input type="date" className="form-control" placeholder="Fin" />
                </div>
              </div>   {/*6   fin */}
              <div className="col-md-4 col-md-offset-2">   {/*8   Block formulaire Partie droite */}
                <div className="form-group">
                  <label>Congés payés</label>
                  <label className="form-control">{this.state.nbCa}</label>
                </div>
                <div className="form-group">
                  <label>RTT</label>
                  <label className="form-control">{this.state.nbRtt}</label>
                </div>
                <div className="form-group">
                  <label>Repos compensateur</label>
                  <label className="form-control">{this.state.nbRc}</label>
                </div>
                <div className="form-group">
                  <label>Valideur</label>
                  <label className="form-control">{responsable}</label>
                </div>
              </div>   {/*8   fin */}
            </div>
            <div className="row">   {/*11   Block Boutons Soumettre et Annuler */}
              <div className="voffsetbas">&nbsp;</div>   {/*12   Cosmétique d'unee marge au dessus des boutons */}{/*12   fin */}
              <div className="col-md-2 col-md-offset-4">
                <a href="index.html" className="btn btn-primary btn-block">Soumettre</a>
              </div>
              <div className="col-md-2 col-md-offset-1">
                <a href="index.html" className="btn btn-primary btn-block">Annuler</a>
              </div>
            </div>   {/*11   fin */}
          </div>   {/*4   fin */}
          <div className="voffsetbas">&nbsp;</div>   {/*13   Cosmétique Ajout d'une marge en dessous des boutons réglable via le css voffsetbas */}   {/*13   fin */}
        </div>   {/*2   fin */}
      </div>
    );
  }
}

export default NouvelleDemande;