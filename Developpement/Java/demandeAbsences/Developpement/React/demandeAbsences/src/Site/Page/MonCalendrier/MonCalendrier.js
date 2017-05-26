import React, { Component } from 'react';

import '../../Bootstrap/dist/css/sb-admin-2.css'
import './moncalendrier.css';

import Users from './donnees/users.json'
import Feries from './donnees/feries.json'
import Absences from './donnees/absences.json'

class MonCalendrier extends Component {
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
            </tbody>
          </table>
        </div>
      </div>
    );
  }
}

export default MonCalendrier;
