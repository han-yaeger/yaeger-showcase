module yaeger.showcase {
    requires hanyaeger.api;

    exports nl.han.showcase;
    exports nl.han.showcase.scenes.mapsandlegends.tilemaps.entities;
    exports nl.han.showcase.scenes.gravity.tilemaps.entities;

    opens audio;
    opens backgrounds;
    opens entities;
}
