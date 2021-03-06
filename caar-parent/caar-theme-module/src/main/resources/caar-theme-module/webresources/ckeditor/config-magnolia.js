/**
 * External plugins added through the server-side FieldFactory are automatically registered.
 * Other external plugins (e.g. client-only) may still be registered here (and subsequently added via config.extraPlugins).
 *
 * e.g. if your plugin resides in src/main/resources/VAADIN/js:
 * CKEDITOR.plugins.addExternal("abbr", CKEDITOR.vaadinDirUrl + "js/abbr/");
 */
CKEDITOR.stylesSet.add( 'mystyles', [
    { name: 'Titulo cabecera', element: 'h2', attributes: { 'class': 'ckeditor title' } },
    { name: 'Frase', element: 'p', attributes: {'class':'ckeditor frase'}},
    {name:'Autor', element: 'p', attributes: {'class': 'ckeditor autor'}},
    {name:'Section title', element: 'h4', attributes: {'class': 'ckeditor content-title'}},
    {name:'Section default text', element: 'p', attributes: {'class': 'ckeditor text-contenido'}}
]);

CKEDITOR.editorConfig = function( config ) {

	// MIRROR info.magnolia.ui.form.field.definition.RichTextFieldDefinition
	definition = {
		alignment: true,
		images: true,
		lists: true,
		source: true,
		tables: true,

		colors: null,
		fonts: null,
		fontSizes: null
	}

	// MIRROR info.magnolia.ui.form.field.factory.RichTextFieldFactory
	removePlugins = [];

	// CONFIGURATION FROM DEFINITION
	if (!definition.alignment) {
		removePlugins.push("justify");
	}
	if (!definition.images) {
		removePlugins.push("image");
	}
	if (!definition.lists) {
		// In CKEditor 4.1.1 enterkey depends on indent which itself depends on list
		removePlugins.push("enterkey");
		removePlugins.push("indent");
		removePlugins.push("list");
	}
	if (!definition.source) {
		removePlugins.push("sourcearea");
	}

	if (!definition.tables) {
		removePlugins.push("table");
		removePlugins.push("tabletools");
	}


	if (definition.colors != null) {
		config.colorButton_colors = definition.colors;
		config.colorButton_enableMore = false;
		removePlugins.push("colordialog");
	} else {
		removePlugins.push("colorbutton");
		removePlugins.push("colordialog");
	}
	if (definition.fonts != null) {
		config.font_names = definition.fonts;
	} else {
		config.removeButtons = "Font";
	}
	if (definition.fontSizes != null) {
		config.fontSize_sizes = definition.fontSizes;
	} else {
		config.removeButtons = "FontSize";
	}
	if (definition.fonts == null && definition.fontSizes == null) {
		removePlugins.push("font");
		removePlugins.push("fontSize");
	}

	// DEFAULT CONFIGURATION FROM FIELD FACTORY
	removePlugins.push("elementspath");
	removePlugins.push("filebrowser");
	config.removePlugins = removePlugins.join(",");
	config.extraPlugins = "magnolialink,magnoliaFileBrowser";
	config.stylesSet = 'mystyles';
	
	config.allowedContent = true;
	config.disallowedContent = 'br';
	
	config.copyFormatting_allowedContexts = false;
	
	config.fillEmptyBlocks = false;

	config.fullPage = false;
	
	config.enterMode = CKEDITOR.ENTER_P;

	config.baseFloatZIndex = 150;
	config.resize_enabled = false;
	config.toolbar = "Magnolia";
	config.toolbar_Magnolia = [

		{ name: "basicstyles",   items: [ "Bold", "Italic", "Underline", "SpecialChar" ] },
		{ name: "paragraph",     items: [ "NumberedList", "BulletedList", "JustifyLeft", "JustifyCenter", "JustifyRight", "JustifyBlock", "Image", "Table" ] },
		{ name: "links",         items: [ "Link", "InternalLink", "DamLink", "Unlink" ] },
		{ name: "undo",          items: [ "Undo", "Redo" ] },
		{ name: "styles",        items: [ "Font", "FontSize", "TextColor" ] },
		{ name: "clipboard",     items: [ "Cut", "Copy", "Paste", "PasteText", "PasteFromWord" ] },
		{ name: "tools",         items: [ "Source" ] },
		{ name: "ownstyles",     items: [ "Styles"] }
	];
};