render() {
        return (
            <Router history={history}>
                <div>
                    <Route path="/" render={this.myHeader} />
                    <Route exact path="/welcome" render={this.loginPage} />
                    <Route path="/app/" render={this.myNav} />
                    <Route path="/app/administrateur" render={this.adminPage} />
                    <Route exact path="/app/administrateur/création" render={this.entitiesPage} />
                    <Route exact path="/app/administrateur/gestion" render={this.promoManagementPage} />
                    <Route exact path="/app/consultation" render={this.readingPage} />
                    <Route exact path="/app/édition_réponses" render={this.editingPage} />
                    <Route exact path="/app/création" render={this.diaryCreationPage} />
                    <Route exact path="/app/édition_conclusions" render={this.conclusionsEditingPage} />
                    <Route exact path="/app/édition_questionnaire" render={this.questionEditingPage} />
                    <Route path="/app/accueil" render={this.indexPage} />
                </div>
            </Router>
        );
    }


    myNav = () => {
        return <MyNav user={this.props.user} deleteUser={this.props.deleteUser} />
    }

// ---------------------------------------------------------------------------------------------------------------

 render() {
    console.log("App render")
    return (
      <MySite
        user={this.state.user}
        loggedIn={this.state.loggedIn}
        getUser={this.getUser}
        deleteUser={this.deleteUser}
        promoId={this.getPromoId}
        studentId={this.getStudentId}
      />
    );
  }
