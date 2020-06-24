import {html, LitElement} from 'https://unpkg.com/@polymer/lit-element/lit-element.js?module';

/* Attributes
 * .options - options in the dropdown
 * id - id of the div containing the dropdown
 * label - initial label at the top of the dropdown
 * changeLabel - whether to change the top label based on selection
 * styling - css classes to apply to all elements in the dropdown */
export class DropdownElement extends LitElement {
  static get properties() {
    return {
      options: {type: Array},
      id: {type: String},
      label: {type: String},
      changeLabel: {type: Boolean},
      showDropdown: {type: String},
      selectedItem: {type: String},
      styling: {type: String},
    };
  }

  constructor() {
    super();
    this.options = [];
    this.id = '';
    this.label = '';
    this.changeLabel = true;
    this.showDropdown = false;
    this.styling = '';
  }

  // Remove shadow DOM so styles are inherited
  createRenderRoot() {
    return this;
  }

  toggleDropdown() {
    this.showDropdown = !this.showDropdown;
  }

  toggleSelectedItem(item) {
    if (this.changeLabel) {
      this.label = item;
    }
  }

  render() {
    let dropdownState = this.showDropdown ? 'is-active' : '';
    return html`        
      <div class=${'dropdown ' + dropdownState + ' ' + this.styling} id=${
        this.id}>
        <div class=${'dropdown-trigger ' + this.styling}>
          <button class=${'button ' + this.styling} @click=${
        this.toggleDropdown} aria-haspopup="true" aria-controls="dropdown-menu">
            <span>${this.label}</span>
            <span class="icon is-small">
              <i class="fa fa-angle-down" aria-hidden="true"></i>
            </span>
          </button>
        </div>
        <div class="${'dropdown-menu ' + this.styling}" id="dropdown-menu" role="menu">
          <div class="dropdown-content">
            ${this.options.map((option) => 
              html`
                <a href="#" @click=${() => this.toggleSelectedItem(option)} class="dropdown-item"> ${option} </a>
              `)}
          </div>
        </div>
      </div>
    `;
  }
}
customElements.define('dropdown-element', DropdownElement);
