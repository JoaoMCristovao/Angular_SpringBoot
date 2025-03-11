import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { PanelComponent } from "./components/panel/panel.component";

@Component({
  selector: 'app-root',
  imports: [PanelComponent],
  templateUrl: './app.component.html',
  styleUrl: './app.component.scss'
})
export class AppComponent {
  title = 'fibonacci-frontend';
}
