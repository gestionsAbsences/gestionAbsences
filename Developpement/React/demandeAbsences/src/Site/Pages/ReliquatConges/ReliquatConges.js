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

  trtEmploye = (i,employe) => {
    let res;
    if (this.props.employe.nomEquipe===employe.nomEquipe) {
      res=<tr key={i}>
        <td>{employe.nom}</td>
        <td>{employe.prenom}</td>
        <td>{employe.matricule}</td>
        <td>{employe.nomResponsable}</td>
        <td>{employe.prenomResponsable}</td>
        <td className="text-center">{employe.nbCa}</td>
        <td className="text-center">{employe.nbRtt}</td>
        <td className="text-center">{employe.nbRc}</td>
      </tr>;
      console.log("Nom équipe :");
      console.log(this.props.employe.nomEquipe);
    }
    return res;
  }

  componentDidMount() {
    //Requête HTTP destinée au Back
    axios({
      method: 'get',
      url: '/emp/listeEmployes',
      data: {},
      headers: {
        'Access-Control-Allow-Origin': '*',
        'Content-Type': 'application/json',
      }
    })
      .then(res => {

        // Incorpore les données dans le State
        this.setState({
          employes: res.data
        });
        if (this.props.employe.modeDev) {
          console.log("Requête satisfaite : ");
          console.log(res);
          console.log("");
        }
      })
      // Traitement des erreurs en mode de Dev.
      .catch((error) => {
        if (this.props.employe.modeDev) {
          if (axios.isCancel(error)) {
            console.log("La requête a été annulée :");
            console.log('Request canceled', error.message);
            console.log("");
          } else if (error.response) {
            console.log("La requête est transmise mais retourne une erreur <200 ou >=300 :");
            console.log(error.response.data);
            console.log(error.response.status);
            console.log(error.response.headers);
            console.log("");
          } else if (error.request) {
            console.log("La requête est transmise mais ne retourne pas de réponse : ");
            console.log(error.request);
            console.log("");
          } else {
            console.log("La requête n'a pu être transmise et déclenche une erreur : ");
            console.log('Error', error.message);
            console.log("");
          }
          console.log("Error.config : ");
          console.log(error.config);
          console.log("");
        }
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
                {this.state.employes.map(
                  (employe, i) =>
                  this.trtEquipe(i,employe)
                )}
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
