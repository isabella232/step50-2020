import {html, LitElement} from 'https://unpkg.com/@polymer/lit-element/lit-element.js?module';

export class DocsComponent extends LitElement {
  static get properties() {
    return {
      documents: {type: Array},
    };
  }

  constructor() {
    super();
    this.documents = [
      {
        "title": "A doc",
        "timestamp": "June 16, 5:28PM"
      },
      {
        "title": "Another doc",
        "timestamp": "June 15, 1:30PM"
      }
    ]
  }

  // Remove shadow DOM so styles are inherited
  createRenderRoot() {
    return this;
  }

  render() {
    return html`        
      <div>
          <div class="title">My Code Docs</div>
          <ul class="docs-list">
            ${this.documents.map((doc) =>
              html`
                <li class="docs-list-element">
                  ${doc.title} <div class="revision-text">Latest Revision: ${doc.timestamp}</div>
                </li>
              `
            )}
          <ul>
      </div>
    `;
  }
}
customElements.define('docs-component', DocsComponent);
