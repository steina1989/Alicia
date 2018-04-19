import React, { PureComponent } from 'react';

export default class Home extends PureComponent {
  render() {
    return (
      <div>
        <h1>Velkomin</h1>
        <h2>
          Alicia er vefkerfi sem leyfir innsendingu verkefna nemenda og yfirferð
          kennara á heimaverkefnum í formi frumkóða.
        </h2>
        <p>
          Aðal inntak verkefnisins er að leyfa skilvirkari og einfaldari
          yfirferð á verkefnum en núverandi kerfi leyfa.
        </p>
        <p>
          Það er gert með samanburði á nemendalausnum og sýnislausn og er
          lausnunum raðað upp með tilliti til fjarlægð þeirra frá sýnislausn.
        </p>
        <a href="https://github.com/steina1989/Alicia">Verkefnið á Github</a>
      </div>
    );
  }
}
