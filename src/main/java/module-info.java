module yaeger.showcase {
    requires hanyaeger.api;

    exports nl.han.showcase;
    exports nl.han.showcase.scenes.entitymaps.tilemaps.entities;

    opens audio;
    opens backgrounds;
    opens entities;
}
