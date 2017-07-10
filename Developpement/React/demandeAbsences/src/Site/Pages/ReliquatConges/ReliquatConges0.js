import React, { Component } from 'react';
import axios from 'axios';

import './reliquatconges.css';

class ReliquatConges extends Component {

  constructor(props) {
      super(props);
      this.state = {
          employes: []
      }
  }

  componentDidMount() {
       axios.get('http://localhost:8080/emp/listeEmployes')
          .then(res => {
              // console.log(res.data);
              this.setState({
                employes: res.data
            });
      });
  }

  render() {
    return (
      <div>
        <div className="panel panel-default">   {/*2   Formulaire */}
          <div className="panel-heading">   {/*3   Titre de la page */}
            <h3 className="panel-title">Reliquat des congés de votre équipe</h3>
          </div>   {/*3   fin */}
          <div className="">   {/*14   Tableau */}
            <table className="table table-bordered table-hover table-striped tablesupmargebas">{/*   Cosmétique Tablesupmargebas, supprime la marge en bas du tableau */}{/* fin */}
              <thead>{/*15   Entête du tableau */}
                <tr>
                  <th>Nom</th>
                  <th>Prénom</th>
                  <th>Matricule</th>
                  <th>Nom Resp</th>
                  <th>Prénom Resp</th>
                  <th>Nb CA</th>
                  <th>Nb RTT</th>
                  <th>Nb RC</th>
                </tr>
              </thead>{/*15 Fin */}
              <tbody>{/*16 Contenu du tableau */}
                {
                  this.state.employes.map(
                    (employe, i) =>
                    <tr key={i}>
                      <td>{employe.nom}</td>
                      <td>{employe.prenom}</td>
                      <td>{employe.matricule}</td>
                      <td>{employe.nomResponsable}</td>
                      <td>{employe.prenomResponsable}</td>
                      <td className="text-center">{employe.nbCa}</td>
                      <td className="text-center">{employe.nbRtt}</td>
                      <td className="text-center">{employe.nbRc}</td>
                    </tr>
                  )
                }
              </tbody>{/*16 Fin */}
            </table>
          </div>   {/*14 Fin */}
        </div>   {/*2 Fin */}
        <div className="VOffSetBasPages">&nbsp;</div>   {/*1   Cosmétique Ajout d'une marge en dessous du formulaire réglable via le css voffsetpos */}{/*1    fin */}
      </div>
    );
  }
}

export default ReliquatConges;
