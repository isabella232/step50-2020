import {html, LitElement} from 'https://unpkg.com/@polymer/lit-element/lit-element.js?module';

export class RenameComponent extends LitElement {
  static get properties() {
    return {
      name: {type: String},
      hash: {type: String}
    };
  }

  constructor() {
    super();
    this.name = '';
    this.hash = '';
  }

  // Remove shadow DOM so styles are inherited
  createRenderRoot() {
    return this;
  }

  render() {
    return html` 
      <div class="modal full-width full-height" id="rename-modal">
      <div class="modal-background"></div>
      <div class="modal-card">
        <header class="modal-card-head">
          <p class="modal-card-title">Rename Document</p>
          <button class="delete" aria-label="close" onclick="hideElement('rename-modal')" />
        </header>
        <section class="modal-card-body">
          <form id="rename-form" onsubmit="hideElement('rename-modal'); return rename()">
            <label for="name">New name for document:</label>
            <input type="text" id="name" name="name"> 
            <input type="submit"></input>
            <input type="hidden" id="documentHash" name="documentHash" value="${this.hash}">
          </form>
        </section>
      </div>
    </div>
    `;
  }
}
customElements.define('rename-component', RenameComponent);
