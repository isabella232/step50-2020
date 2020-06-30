import {html, LitElement} from 'https://unpkg.com/@polymer/lit-element/lit-element.js?module';
import {DropdownElement} from './dropdown-element.js';

export class ToolbarComponent extends LitElement {
  static get properties() {
    return {
      languages: {type: Array},
    };
  }

  constructor() {
    super();
    this.languages = ["python", "java"];
  }

  // Remove shadow DOM so styles are inherited
  createRenderRoot() {
    return this;
  }

  render() {
    return html`        
      <div>
        <dropdown-element 
          .options="${this.languages}" 
          name="language"
          label="Languages">
        </dropdown-element>
      </div>
    `;
  }
}
customElements.define('toolbar-component', ToolbarComponent);
