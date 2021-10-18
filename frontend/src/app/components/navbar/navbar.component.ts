import {Component} from '@angular/core';

@Component({
  selector: 'app-navbar',
  template: `
      <header>
      <nav class="navbar navbar-expand-md navbar-dark fixed-top bg-navbar">
        <a class="navbar-brand" href="#">Estaciona Fácil</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarCollapse"
                aria-controls="navbarCollapse" aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarCollapse">
          <ul class="navbar-nav mr-auto">
            <li class="nav-item">
              <a class="nav-link " routerLink="/home" routerLinkActive="active">Home</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" routerLink="/vagas" routerLinkActive="active">Vagas</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" routerLink="/movimento" routerLinkActive="active">Movimento</a>
            </li>
          </ul>
        </div>
      </nav>
    </header>
  `,
  styles: [
    '.bg-navbar {background-color: #0048ff;} ' +
    '.active {font-weight: bold;}'
  ]
})
export class NavbarComponent {}
