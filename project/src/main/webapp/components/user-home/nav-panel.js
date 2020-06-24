import {html, LitElement} from 'https://unpkg.com/@polymer/lit-element/lit-element.js?module';
import {DropdownElement} from '../dropdown-element.js';

export class NavPanel extends LitElement {
  static get properties() {
    return {
      languages: {type: Array},
    };
  }

  constructor() {
    super();
    this.languages = ['Python', 'Javacript']
  }

  // Remove shadow DOM so styles are inherited
  createRenderRoot() {
    return this;
  }

  render() {
    return html`   
      <div>
        <div class="new-doc-group">
          <input class="white-input full-width" placeholder="Write a document title..." />
          <dropdown-element 
            .options="${this.languages}" 
            id="languages"
            label="Languages"
            styling="full-width">
          </dropdown-element>
          <button class="primary-blue-btn full-width"> + New doc</button>
        </div>
        <div class="nav-btn-group">
          <button class="text-btn full-width"> My code docs </button>
          <button class="text-btn full-width"> Shared with me </button>
        </div>
      </div>
    `;
  }
}
customElements.define('nav-panel', NavPanel);
