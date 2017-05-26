import React, { Component } from 'react';

import '../../Bootstrap/dist/css/sb-admin-2.css'
import './listedemandes.css';

import liste from './listedemandes.json'

class ListeDemandes extends Component {
  render() {
    return (
      <div>
        <div className="voffsetpos">&nbsp;</div>   {/*1   Cosmétique Ajout d'une marge au dessus du formulaire réglable via le css voffsetpos */}{/*1    fin */}
        <div className="panel panel-default">   {/*2   Formulaire */}
          <div className="panel-heading">   {/*3   Titre de la page */}
              <h3 className="panel-title">Liste de vos dernières demandes</h3>
          </div>   {/*3   fin */}
          <div className="">   {/*14   Tableau */}
            <table className="table table-bordered table-hover table-striped tablesupmargebas">   {/*   Cosmétique Tablesupmargebas, supprime la marge en bas du tableau */}{/* fin */}
              <thead>   {/*15   Entête du tableau */}
                <tr>
                  <th>N° demande</th>
                  <th>Prénom</th>
                  <th>Nom</th>
                  <th>Nom Resp</th>
                  <th>Nom Resp</th>
                  <th>Type</th>
                  <th>Début</th>
                  <th>Fin</th>
                  <th>Statut</th>
                  <th>Action</th>
                </tr>
              </thead>   {/*15 Fin */}
              <tbody>   {/*16 Contenu du tableau */}
              {
                liste.absences.map(
                  (absence, i) =>
                  <tr key={i}>
                    <td><a href="#">{absence.demande}</a></td>
                    <td>{absence.nom}</td>
                    <td>{absence.prenom}</td>
                    <td>{absence.nomresp}</td>
                    <td>{absence.prenomresp}</td>
                    <td>{absence.type}</td>
                    <td>{absence.debut}</td>
                    <td>{absence.fin}</td>
                    <td>{absence.statut}</td>
                    <td>
                    <a href={absence.lien}>{absence.action}</a>
                    </td>
                  </tr>
                )
              }
              </tbody>   {/*16 Fin */}
            </table>
          </div>   {/*14 Fin */}
        </div>   {/*2 Fin */}
      </div>
    );
  }
}

export default ListeDemandes;
