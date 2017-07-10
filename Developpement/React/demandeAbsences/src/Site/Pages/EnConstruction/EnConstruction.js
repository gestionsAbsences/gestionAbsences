import React, { Component } from 'react';

import './enconstruction.css';

import travaux from '../../Medias/Travaux.jpg';

class EnConstruction extends Component {
  render() {
    return (
      <div>
        <div className="panel panel-default">   {/*2   Formulaire */}
          <div className="panel-heading">   {/*3   Titre de Formulaire */}
            <h3 className="panel-title">Page en cours de construction</h3>
          </div>   {/*3   fin */}
          <div className="panel-body">   {/*4   Contenu Formulaire */}
            <div className="VOffSetHautPages">&nbsp;</div>   {/*5   Cosmétique Ajout d'une marge au dessus du contenu du formulaire réglable via le css VOffSetHautPages */}{/*5   fin */}
            <div className="row">
              <div className="col-md-4 col-md-offset-4">   {/*6   Formulaire Partie gauche */}
                <img className="travaux" src={travaux} alt="" />
              </div>   {/*6   fin */}
            </div>
          </div>   {/*4   fin */}
          <div className="VOffSetBasPages">&nbsp;</div>   {/*13   Cosmétique Ajout d'une marge en dessous des boutons réglable via le css VOffSetBasPages */}   {/*13   fin */}
        </div>   {/*2   fin */}
      </div>
    );
  }
}

export default EnConstruction;
