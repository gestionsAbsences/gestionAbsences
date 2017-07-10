import React, { Component } from 'react';

import './listedemandes.css';


class ListeDemandes extends Component {

  constructor(props) {
    super(props); // Récupère le Props du parent
    this.props=props;
  }

  formatDate(date) { // Convertit la date au format dd/mm/aaaa
    return (
      date.substr(-2) + "/" + date.substr(5,2) + "/" + date.substr(0,4)
    )
  }

  action = (role, statut, dateDebut) => {
    let laDate = new Date();
    let laDateDuJour = laDate.getFullYear() +""+ ("0"+laDate.getMonth()).substr(-2) +""+ ("0"+laDate.getDate()).substr(-2);
    let debut =  dateDebut.substr(0,4) + "" +  dateDebut.substr(5,2) + "" + dateDebut.substr(-2);
    let lien;

    if (statut==="Nouvelle demande" && role===0) {
      lien=<div><a href="#">Relancer</a> ou <a href="#">Annuler</a></div>;
    }
    if (statut==="En attente de validation du Responsable" && role===0) {
      lien=<div><a href="#">Relancer</a> ou <a href="#">Annuler</a></div>;
    }
    if (statut==="En attente de décision RH" && role===0) {
      lien=<div><a href="#">Relancer</a> ou <a href="#">Annuler</a></div>;
    }
    if (statut==="Validé" && role===0 && debut>=laDateDuJour) {
      lien=<div><a href="#">Annuler</a></div>;
    }
    if (statut==="En attente de validation du Responsable" && role===1 && debut>=laDateDuJour) {
      lien=<div><a href="#">Décider</a></div>;
    }
    if (statut==="En attente de décision RH" && role===1) {
      lien=<div><a href="#">Relancer</a> ou <a href="#">Annuler</a></div>;
    }
    if (statut==="Validé" && role===1 && debut>=laDateDuJour) {
      lien=<div><a href="#">Annuler</a></div>;
    }
    if (statut==="En attente de décision RH" && role===2) {
      lien=<div><a href="#">Décider</a></div>;
    }

    return lien;
  }

  formatDemande(demande) { // Convertit le N° Demande au format DEMXXXXXX
    return (
      "DEM" + ("000000" + demande).substr(-6)
    )
  }

  render() {
    return (
      <div>
        <div className="panel panel-default">   {/*2   Formulaire */}
          <div className="panel-heading">   {/*3   Titre de la page */}
            <h3 className="panel-title">Liste de vos dernières demandes</h3>
          </div>   {/*3   fin */}
          <div className="panel-body">
          	<div className="dataTables_wrapper form-inline dt-bootstrap no-footer" id="dataTables-example_wrapper">
          		<div className="row">
          			<div className="col-sm-6">
          				<div id="dataTables-example_length" className="dataTables_length">
          					<label className="ajust">Show&nbsp;&nbsp;
          						<select className="form-control input-sm" aria-controls="dataTables-example" name="dataTables-example_length">
          							<option value="10">10</option>
          							<option value="25">25</option>
          							<option value="50">50</option>
          							<option value="100">100</option>
          						</select>&nbsp;&nbsp;entries
          					</label>
          				</div>
          			</div>
          			<div className="col-sm-6">
          				<div className="dataTables_filter pull-right" id="dataTables-example_filter">
          					<label className="ajust">Search :&nbsp;
          						<input aria-controls="dataTables-example" placeholder="" className="form-control input-sm" type="search" />
          					</label>
          				</div>
          			</div>
          		</div>
          		<div className="row">
          			<div className="col-sm-12">
          				<table aria-describedby="dataTables-example_info" role="grid" className="table table-striped table-bordered table-hover dataTable no-footer dtr-inline" id="dataTables-example">
          					<thead>
          						<tr role="row">
                        <th aria-label="Rendering engine: activate to sort column descending" aria-sort="ascending" aria-controls="dataTables-example" tabIndex="0" className="sorting_asc">N° demande</th>
          							<th aria-label="Browser: activate to sort column ascending" aria-controls="dataTables-example" tabIndex="0" className="sorting">Nom</th>
          							<th aria-label="Platform(s): activate to sort column ascending" aria-controls="dataTables-example" tabIndex="0" className="sorting">Prénom</th>
          							<th aria-label="Engine version: activate to sort column ascending" aria-controls="dataTables-example" tabIndex="0" className="sorting">Nom Resp</th>
                        <th aria-label="CSS grade: activate to sort column ascending" aria-controls="dataTables-example" tabIndex="0" className="sorting">Prénom Resp</th>
                        <th aria-label="CSS grade: activate to sort column ascending" aria-controls="dataTables-example" tabIndex="0" className="sorting">Type</th>
                        <th aria-label="CSS grade: activate to sort column ascending" aria-controls="dataTables-example" tabIndex="0" className="sorting">Début</th>
                        <th aria-label="CSS grade: activate to sort column ascending" aria-controls="dataTables-example" tabIndex="0" className="sorting">Fin</th>
                        <th aria-label="CSS grade: activate to sort column ascending" aria-controls="dataTables-example" tabIndex="0" className="sorting">Statut</th>
                        <th aria-label="CSS grade: activate to sort column ascending" aria-controls="dataTables-example" tabIndex="0" className="sorting">Action</th>
          						</tr>
          					</thead>
          					<tbody>
                      {
                        this.props.employe.absences.map(
                          (absence, i) =>
                          <tr role="row" className="gradeA odd" key={i}>
                            <td className="sorting_1">{this.formatDemande(absence.numDemande)}</td>
                            <td>{this.props.employe.nom}</td>
                            <td>{this.props.employe.prenom}</td>
                            <td>{this.props.employe.nomResponsable}</td>
                            <td>{this.props.employe.prenomResponsable}</td>
                            <td>{absence.type}</td>
                            <td>{this.formatDate(absence.debut)}</td>
                            <td>{this.formatDate(absence.fin)}</td>
                            <td>{absence.statut}</td>
                            <td>{this.action(this.props.employe.role, absence.statut, absence.debut)}</td>
                          </tr>
                        )
                      }
                    </tbody>{/*16 Fin */}
                  </table>
                  </div>
            		</div>
            		<div className="row">
            			<div className="col-sm-6">
            				<div aria-live="polite" role="status" id="dataTables-example_info" className="dataTables_info">Showing 1 to 10 of 57 entries</div>
            			</div>
            			<div className="col-sm-6">
            				<div id="dataTables-example_paginate" className="dataTables_paginate paging_simple_numbers">
            					<ul className="pagination">
            						<li id="dataTables-example_previous" tabIndex="0" aria-controls="dataTables-example" className="paginate_button previous disabled">
            							<a href="#">Previous</a>
            						</li>
            						<li tabIndex="0" aria-controls="dataTables-example" className="paginate_button active">
            							<a href="#">1</a>
            						</li>
            						<li tabIndex="0" aria-controls="dataTables-example" className="paginate_button ">
            							<a href="#">2</a>
            						</li>
            						<li tabIndex="0" aria-controls="dataTables-example" className="paginate_button ">
            							<a href="#">3</a>
            						</li>
            						<li tabIndex="0" aria-controls="dataTables-example" className="paginate_button ">
            							<a href="#">4</a>
            						</li>
            						<li tabIndex="0" aria-controls="dataTables-example" className="paginate_button ">
            							<a href="#">5</a>
            						</li>
            						<li tabIndex="0" aria-controls="dataTables-example" className="paginate_button ">
            							<a href="#">6</a>
            						</li>
            						<li id="dataTables-example_next" tabIndex="0" aria-controls="dataTables-example" className="paginate_button next">
            							<a href="#">Next</a>
            						</li>
            					</ul>
            				</div>
            			</div>
                </div>
              </div>
            </div>
          {/*</div>   14 Fin */}
        </div>   {/*2 Fin */}
        <div className="VOffSetBasPages">&nbsp;</div>   {/*1   Cosmétique Ajout d'une marge en dessous du formulaire réglable via le css voffsetpos */}{/*1    fin */}
      </div>
    );
  }
}

export default ListeDemandes;
