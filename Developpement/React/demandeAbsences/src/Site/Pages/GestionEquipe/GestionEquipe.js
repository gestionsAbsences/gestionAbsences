import React, { Component } from 'react';

import axios from 'axios';

// import '../../Bootstrap/dist/css/sb-admin-2.css'
import './gestionequipe.css';

let nom="PEREZ";

class GestionEquipe extends Component {

    constructor(props) {
        super(props);
        this.state = {
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
            <h3 className="panel-title">Gestion d'équipe</h3>                 {/*'*/}{/* Factice Pour rectifier bug d'affichage sur Atom */}
          </div>   {/*3   fin */}
          <div className="panel-body">   {/*4   Contenu Formulaire */}
            <div className="voffsethaut">&nbsp;</div>   {/*5   Cosmétique Ajout d'une marge au dessus du contenu du formulaire réglable via le css voffsethaut */}{/*5   fin */}
            <div className="row">
              <div className="col-md-4 col-md-offset-1">   {/*6   Formulaire Partie gauche */}
                <div className="form-group">   {/*7   Un des champs select du Formulaire */}
                  <label>Equipe</label>                                       {/*'*/}
                  <input className="form-control" placeholder="Equipe" />
                </div>   {/*7   fin */}
                <div className="form-group">
                  <label>Responsable</label>                                     {/*'*/}
                  <input className="form-control" placeholder="Responsable" />
                </div>
                <div className="form-group">
                  <label>Equipe mère</label>                                     {/*'*/}
                  <input className="form-control" placeholder="Equipe mère" />
                </div>
                <div className="form-group">
                  <label>Gestionnaire RH</label>                                     {/*'*/}
                  <input className="form-control" placeholder="ServiceRH" />
                </div>
              </div>   {/*6   fin */}
              <div className="col-md-4 col-md-offset-2">   {/*8   Block formulaire Partie droite */}

                <div className="form-group">
                  <label>Membre de l'équipe</label>                                     {/*'*/}
                  <div className="cadretablo">
                    <table className="table table-bordered table-responsive table-hover table-striped tablesupmargebas tablo">{/*   Cosmétique Tablesupmargebas, supprime la marge en bas du tableau */}{/* fin */}
                      <thead className="contenutablo">{/*15   Entête du tableau */}
                        <tr>
                          <th>Nom</th>
                          <th>Prénom</th>
                        </tr>
                      </thead>{/*15 Fin */}
                      <tbody className="contenutablo scrollable">{/*16 Contenu du tableau */}
                        <tr>
                          <td>ARMAND</td>
                          <td>Fulbert</td>
                        </tr>
                        <tr>
                          <td>CHAUMETTE</td>
                          <td>Ernest</td>
                        </tr>
                        <tr>
                          <td>FARDET</td>
                          <td>Gondran</td>
                        </tr>
                        <tr>
                          <td>FOURQUAY</td>
                          <td>Anatole</td>
                        </tr>
                        <tr>
                          <td>URBAIN</td>
                          <td>Gertrude</td>
                        </tr>
                        <tr>
                          <td>ARMAND</td>
                          <td>Fulbert</td>
                        </tr>
                        <tr>
                          <td>CHAUMETTE</td>
                          <td>Ernest</td>
                        </tr>
                        <tr>
                          <td>FARDET</td>
                          <td>Gondran</td>
                        </tr>
                        <tr>
                          <td>FOURQUAY</td>
                          <td>Anatole</td>
                        </tr>
                        <tr>
                          <td>URBAIN</td>
                          <td>Gertrude</td>
                        </tr>
                        <tr>
                          <td>ARMAND</td>
                          <td>Fulbert</td>
                        </tr>
                        <tr>
                          <td>CHAUMETTE</td>
                          <td>Ernest</td>
                        </tr>
                        <tr>
                          <td>FARDET</td>
                          <td>Gondran</td>
                        </tr>
                        <tr>
                          <td>FOURQUAY</td>
                          <td>Anatole</td>
                        </tr>
                        <tr>
                          <td>URBAIN</td>
                          <td>Gertrude</td>
                        </tr>
                        <tr>
                          <td>ARMAND</td>
                          <td>Fulbert</td>
                        </tr>
                        <tr>
                          <td>CHAUMETTE</td>
                          <td>Ernest</td>
                        </tr>
                        <tr>
                          <td>FARDET</td>
                          <td>Gondran</td>
                        </tr>
                        <tr>
                          <td>FOURQUAY</td>
                          <td>Anatole</td>
                        </tr>
                        <tr>
                          <td>URBAIN</td>
                          <td>Gertrude</td>
                        </tr>
                        <tr>
                          <td>ARMAND</td>
                          <td>Fulbert</td>
                        </tr>
                        <tr>
                          <td>CHAUMETTE</td>
                          <td>Ernest</td>
                        </tr>
                        <tr>
                          <td>FARDET</td>
                          <td>Gondran</td>
                        </tr>
                        <tr>
                          <td>FOURQUAY</td>
                          <td>Anatole</td>
                        </tr>
                        <tr>
                          <td>URBAIN</td>
                          <td>Gertrude</td>
                        </tr>
                      </tbody>{/*16 Fin */}
                    </table>
                  </div>
                </div>
              </div>   {/*8   fin */}
              <div className="col-md-1"></div>
            </div>
            <div className="row">   {/*11   Block Boutons Soumettre et Annuler */}
              <div className="voffsetbas">&nbsp;</div>   {/*12   Cosmétique d'unee marge au dessus des boutons */}{/*12   fin */}
              <div className="col-md-10 col-md-offset-1">
                <div className="col-md-3">
                  <a href="index.html" className="btn btn-primary btn-block">Nouveau</a>
                </div>
                <div className="col-md-3">
                  <a href="index.html" className="btn btn-primary btn-block">Supprimer</a>
                </div>
                <div className="col-md-3">
                  <a href="index.html" className="btn btn-primary btn-block">Enregistrer</a>
                </div>
                <div className="col-md-3">
                  <a href="index.html" className="btn btn-primary btn-block">Annuler</a>
                </div>
              </div>

            </div>   {/*11   fin */}
          </div>   {/*4   fin */}
          <div className="voffsetbas">&nbsp;</div>   {/*13   Cosmétique Ajout d'une marge en dessous des boutons réglable via le css voffsetbas */}   {/*13   fin */}
        </div>   {/*2   fin */}
      </div>
    );
  }
}

export default GestionEquipe;
