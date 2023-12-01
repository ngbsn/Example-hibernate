CREATE TABLE "album"
(
    "album_id" SERIAL NOT NULL,
    "title" varchar(160) NOT NULL,
    "artist_id" INT NOT NULL,
    CONSTRAINT "PK_Album" PRIMARY KEY  ("album_id")
);

CREATE TABLE "artist"
(
    "artist_id" SERIAL NOT NULL,
    "name" varchar(120),
    CONSTRAINT "PK_Artist" PRIMARY KEY  ("artist_id")
);

CREATE TABLE "customer"
(
    "customer_id" SERIAL NOT NULL,
    "first_name" VARCHAR(40) NOT NULL,
    "last_name" VARCHAR(20) NOT NULL,
    "company" VARCHAR(80),
    "address" VARCHAR(70),
    "city" VARCHAR(40),
    "state" VARCHAR(40),
    "country" VARCHAR(40),
    "postal_code" VARCHAR(10),
    "phone" VARCHAR(24),
    "fax" VARCHAR(24),
    "email" VARCHAR(60) NOT NULL,
    "support_rep_id" INT,
    CONSTRAINT "PK_Customer" PRIMARY KEY  ("customer_id")
);

CREATE TABLE "employee"
(
    "employee_id" SERIAL NOT NULL,
    "last_name" VARCHAR(20) NOT NULL,
    "first_name" VARCHAR(20) NOT NULL,
    "title" VARCHAR(30),
    "reports_to" INT,
    "birth_date" TIMESTAMP,
    "hire_date" TIMESTAMP,
    "address" VARCHAR(70),
    "city" VARCHAR(40),
    "state" VARCHAR(40),
    "country" VARCHAR(40),
    "postal_code" VARCHAR(10),
    "phone" VARCHAR(24),
    "fax" VARCHAR(24),
    "email" VARCHAR(60),
    CONSTRAINT "PK_Employee" PRIMARY KEY  ("employee_id")
);

CREATE TABLE "genre"
(
    "genre_id" SERIAL NOT NULL,
    "name" VARCHAR(120),
    CONSTRAINT "PK_Genre" PRIMARY KEY  ("genre_id")
);

CREATE TABLE "invoice"
(
    "invoice_id" SERIAL NOT NULL,
    "customer_id" INT NOT NULL,
    "invoice_date" TIMESTAMP NOT NULL,
    "billing_address" VARCHAR(70),
    "billing_city" VARCHAR(40),
    "billing_state" VARCHAR(40),
    "billing_country" VARCHAR(40),
    "billing_postal_code" VARCHAR(10),
    "total" NUMERIC(10,2) NOT NULL,
    CONSTRAINT "PK_Invoice" PRIMARY KEY  ("invoice_id")
);

CREATE TABLE "invoice_line"
(
    "invoice_line_id" SERIAL NOT NULL,
    "invoice_id" INT NOT NULL,
    "track_id" INT NOT NULL,
    "unit_price" NUMERIC(10,2) NOT NULL,
    "quantity" INT NOT NULL,
    CONSTRAINT "PK_InvoiceLine" PRIMARY KEY  ("invoice_line_id")
);

CREATE TABLE "media_type"
(
    "media_type_id" SERIAL NOT NULL,
    "name" VARCHAR(120),
    CONSTRAINT "PK_MediaType" PRIMARY KEY  ("media_type_id")
);

CREATE TABLE "playlist"
(
    "playlist_id" SERIAL NOT NULL,
    "name" VARCHAR(120),
    CONSTRAINT "PK_Playlist" PRIMARY KEY  ("playlist_id")
);

CREATE TABLE "playlist_track"
(
    "playlist_id" SERIAL NOT NULL,
    "track_id" INT NOT NULL,
    CONSTRAINT "PK_PlaylistTrack" PRIMARY KEY  ("playlist_id", "track_id")
);

CREATE TABLE "track"
(
    "track_id" SERIAL NOT NULL,
    "name" VARCHAR(200) NOT NULL,
    "album_id" INT,
    "media_type_id" INT NOT NULL,
    "genre_id" INT,
    "composer" VARCHAR(220),
    "milliseconds" INT NOT NULL,
    "bytes" INT,
    "unit_price" NUMERIC(10,2) NOT NULL,
    CONSTRAINT "PK_Track" PRIMARY KEY  ("track_id")
);



/*******************************************************************************
   Create Primary Key Unique Indexes
********************************************************************************/

/*******************************************************************************
   Create Foreign Keys
********************************************************************************/
ALTER TABLE "album" ADD CONSTRAINT "FK_AlbumArtistId"
    FOREIGN KEY ("artist_id") REFERENCES "artist" ("artist_id") ON DELETE NO ACTION ON UPDATE NO ACTION;

CREATE INDEX "IFK_AlbumArtistId" ON "album" ("artist_id");

ALTER TABLE "customer" ADD CONSTRAINT "FK_CustomerSupportRepId"
    FOREIGN KEY ("support_rep_id") REFERENCES "employee" ("employee_id") ON DELETE NO ACTION ON UPDATE NO ACTION;

CREATE INDEX "IFK_CustomerSupportRepId" ON "customer" ("support_rep_id");

ALTER TABLE "employee" ADD CONSTRAINT "FK_EmployeeReportsTo"
    FOREIGN KEY ("reports_to") REFERENCES "employee" ("employee_id") ON DELETE NO ACTION ON UPDATE NO ACTION;

CREATE INDEX "IFK_EmployeeReportsTo" ON "employee" ("reports_to");

ALTER TABLE "invoice" ADD CONSTRAINT "FK_InvoiceCustomerId"
    FOREIGN KEY ("customer_id") REFERENCES "customer" ("customer_id") ON DELETE NO ACTION ON UPDATE NO ACTION;

CREATE INDEX "IFK_InvoiceCustomerId" ON "invoice" ("customer_id");

ALTER TABLE "invoice_line" ADD CONSTRAINT "FK_InvoiceLineInvoiceId"
    FOREIGN KEY ("invoice_id") REFERENCES "invoice" ("invoice_id") ON DELETE NO ACTION ON UPDATE NO ACTION;

CREATE INDEX "IFK_InvoiceLineInvoiceId" ON "invoice_line" ("invoice_id");

ALTER TABLE "invoice_line" ADD CONSTRAINT "FK_InvoiceLineTrackId"
    FOREIGN KEY ("track_id") REFERENCES "track" ("track_id") ON DELETE NO ACTION ON UPDATE NO ACTION;

CREATE INDEX "IFK_InvoiceLineTrackId" ON "invoice_line" ("track_id");

ALTER TABLE "playlist_track" ADD CONSTRAINT "FK_PlaylistTrackPlaylistId"
    FOREIGN KEY ("playlist_id") REFERENCES "playlist" ("playlist_id") ON DELETE NO ACTION ON UPDATE NO ACTION;

ALTER TABLE "playlist_track" ADD CONSTRAINT "FK_PlaylistTrackTrackId"
    FOREIGN KEY ("track_id") REFERENCES "track" ("track_id") ON DELETE NO ACTION ON UPDATE NO ACTION;

CREATE INDEX "IFK_PlaylistTrackTrackId" ON "playlist_track" ("track_id");

ALTER TABLE "track" ADD CONSTRAINT "FK_TrackAlbumId"
    FOREIGN KEY ("album_id") REFERENCES "album" ("album_id") ON DELETE NO ACTION ON UPDATE NO ACTION;

CREATE INDEX "IFK_TrackAlbumId" ON "track" ("album_id");

ALTER TABLE "track" ADD CONSTRAINT "FK_TrackGenreId"
    FOREIGN KEY ("genre_id") REFERENCES "genre" ("genre_id") ON DELETE NO ACTION ON UPDATE NO ACTION;

CREATE INDEX "IFK_TrackGenreId" ON "track" ("genre_id");

ALTER TABLE "track" ADD CONSTRAINT "FK_TrackMediaTypeId"
    FOREIGN KEY ("media_type_id") REFERENCES "media_type" ("media_type_id") ON DELETE NO ACTION ON UPDATE NO ACTION;

CREATE INDEX "IFK_TrackMediaTypeId" ON "track" ("media_type_id");
