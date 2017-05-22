import React, { Component } from 'react';

import '../../Bootstrap/dist/css/sb-admin-2.css'
import './listedemandes.css';

import liste from './listedemandes.json'

class ListeDemandes extends Component {
  render() {
    return (
      <div className="listedemande">
        <h2>Liste de vos dernières demandes</h2>
        <div className="">
          <table className="table table-bordered table-hover table-striped">
            <thead>
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
            </thead>

            <tbody>
            {
              liste.absences.map(
                (absence, i) =>
                <tr key={i}>
                  <td>{absence.demande}</td>
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
            </tbody>
          </table>
        </div>
      </div>
    );
  }
}

export default ListeDemandes;
