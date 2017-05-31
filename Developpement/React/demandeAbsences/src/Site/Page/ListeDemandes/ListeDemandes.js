import React, { Component } from 'react';
import axios from 'axios';

import './listedemandes.css';

import liste from './listedemandes.json'

let id="3";

class ListeDemandes extends Component {

  constructor(props) {
      super(props);
      this.state = {
          absences: [],
          nom: "",
          prenom: "",
          nomResp: [],
          prenomResp: [],
          action: []
      }
  }

  componentDidMount() {
       axios.get('http://localhost:8080/absence/getAbsenceById?id='+id)
          .then(res => {
              console.log(res.data[0].employe.absence);
              this.setState({
                absences: res.data[0].employe.absence,
                nom: res.data[0].employe.nom,
                prenom: res.data[0].employe.prenom
              });
      });
  }

    formatDate(date) {
      return (
        date.substr(-2) +"/"+ date.substr(5,2) +"/"+ date.substr(0,4)
      )
    }

  render() {
    return (
      <div>
        <div className="voffsetpos">&nbsp;</div>   {/*1   Cosmétique Ajout d'une marge au dessus du formulaire réglable via le css voffsetpos */}{/*1    fin */}
        <div className="panel panel-default">   {/*2   Formulaire */}
          <div className="panel-heading">   {/*3   Titre de la page */}
            <h3 className="panel-title">Liste de vos dernières demandes</h3>
          </div>   {/*3   fin */}
          <div className="">   {/*14   Tableau */}
            <table className="table table-bordered table-hover table-striped tablesupmargebas">{/*   Cosmétique Tablesupmargebas, supprime la marge en bas du tableau */}{/* fin */}
              <thead>{/*15   Entête du tableau */}
                <tr>
                  <th>N° demande</th>
                  <th>Prénom</th>
                  <th>Nom</th>
                  <th>Nom Resp</th>
                  <th>Prénom Resp</th>
                  <th>Type</th>
                  <th>Début</th>
                  <th>Fin</th>
                  <th>Statut</th>
                  <th>Action</th>
                </tr>
              </thead>{/*15 Fin */}
              <tbody>{/*16 Contenu du tableau */}
                {
                  this.state.absences.map(
                    (absence, i) =>
                    <tr key={i}>
                      <td>DEM{("000000" + absence.id).substr(-6)}</td>
{/*
                      <td>{absence.nom}</td>
                      <td>{absence.prenom}</td>
                      <td>{absence.nomresp}</td>
                      <td>{absence.prenomresp}</td>
*/}
                      <td>{this.state.nom}</td>
                      <td>{this.state.prenom}</td>
                      <td>absence.nomresp</td>
                      <td>absence.prenomresp</td>

                      <td>{absence.type.nom}</td>
                      <td>{this.formatDate(absence.debut)}</td>
                      <td>{this.formatDate(absence.fin)}</td>
                      <td>{absence.statut.nom}</td>
{/*
                      <td><a href={absence.lien}>{absence.action}</a></td>
*/}
                      <td>{/*<a href="#">absence.action</a>*/}</td>
                    </tr>
                  )
                }
              </tbody>{/*16 Fin */}
            </table>
          </div>   {/*14 Fin */}
        </div>   {/*2 Fin */}
      </div>
    );
  }
}

export default ListeDemandes;
