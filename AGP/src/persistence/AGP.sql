#------------------------------------------------------------
#        Script MySQL.
#------------------------------------------------------------


#------------------------------------------------------------
# Table: TOURISTIC_SITE
#------------------------------------------------------------

CREATE TABLE TOURISTIC_SITE(
        ID_SITE   int (11) Auto_increment  NOT NULL ,
        NAME      Varchar (25) NOT NULL ,
        PRICE     Int NOT NULL ,
        PICTURE   Blob ,
        TYPE      Varchar (25) NOT NULL ,
        ADDRESS   Varchar (25) ,
        LONGITUDE BigInt ,
        LATITUDE  BigInt ,
        PRIMARY KEY (ID_SITE )
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: HOTEL
#------------------------------------------------------------

CREATE TABLE hotel(
        ID_HOTEL  int (11) Auto_increment  NOT NULL ,
        HRANGE    Int NOT NULL ,
        PRICE     Int NOT NULL ,
        PICTURE   Blob ,
        NAME      Varchar (25) NOT NULL ,
        ADDRESS   Varchar (25) ,
        LONGITUDE BigInt ,
        LATITUDE  BigInt ,
        PRIMARY KEY (ID_HOTEL )
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: EXCURSION
#------------------------------------------------------------

CREATE TABLE EXCURSION(
        ID_EXCURSION int (11) Auto_increment  NOT NULL ,
        NAME         Varchar (25) NOT NULL ,
        DURATION     Int NOT NULL ,
        PRICE        Int NOT NULL ,
        CONFORT      Int NOT NULL ,
        ID_TRANSPORT Int NOT NULL ,
        PRIMARY KEY (ID_EXCURSION )
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: TRANSPORT
#------------------------------------------------------------

CREATE TABLE transport(
        ID_TRANSPORT int (11) Auto_increment  NOT NULL ,
        MODE         Varchar (200) ,
        DURATION     Int NOT NULL ,
        PRIMARY KEY (ID_TRANSPORT )
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: LIEN2
#------------------------------------------------------------

CREATE TABLE LIEN2(
        ID_SITE      Int NOT NULL ,
        ID_EXCURSION Int NOT NULL ,
        PRIMARY KEY (ID_SITE ,ID_EXCURSION )
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: LIEN1
#------------------------------------------------------------

CREATE TABLE LIEN1(
        ID_SITE  Int NOT NULL ,
        ID_HOTEL Int NOT NULL ,
        PRIMARY KEY (ID_SITE ,ID_HOTEL )
)ENGINE=InnoDB;

ALTER TABLE EXCURSION ADD CONSTRAINT FK_EXCURSION_ID_TRANSPORT FOREIGN KEY (ID_TRANSPORT) REFERENCES TRANSPORT(ID_TRANSPORT);
ALTER TABLE LIEN2 ADD CONSTRAINT FK_LIEN2_ID_SITE FOREIGN KEY (ID_SITE) REFERENCES TOURISTIC_SITE(ID_SITE);
ALTER TABLE LIEN2 ADD CONSTRAINT FK_LIEN2_ID_EXCURSION FOREIGN KEY (ID_EXCURSION) REFERENCES EXCURSION(ID_EXCURSION);
ALTER TABLE LIEN1 ADD CONSTRAINT FK_LIEN1_ID_SITE FOREIGN KEY (ID_SITE) REFERENCES TOURISTIC_SITE(ID_SITE);
ALTER TABLE LIEN1 ADD CONSTRAINT FK_LIEN1_ID_HOTEL FOREIGN KEY (ID_HOTEL) REFERENCES HOTEL(ID_HOTEL);

INSERT INTO `hotel` (`ID_HOTEL`, `HRANGE`, `PRICE`, `PICTURE`, `NAME`, `ADDRESS`, `LONGITUDE`, `LATITUDE`) VALUES
(1, 5, 23, 0x687474703a2f2f6c6f63616c686f73743a383838382f70726f6a65744167702f696d672f686f74656c2d7365796368656c6c65732e6a7067, 'six-sense zil pasyon', 'Unnamed Road, Seychelles', 0, 0),
(2, 3, 65, 0x687474703a2f2f6c6f63616c686f73743a383838382f70726f6a65744167702f696d672f686f74656c2e4a504547, 'Heliconia Grove', 'Praslin, Seychelles, Seychelles', 0, 0),
(46, 4, 13, 0x687474703a2f2f6c6f63616c686f73743a383838382f70726f6a65744167702f696d672f696d616765732831292e6a706567, 'Villas du Voyageur', 'Anse Kerlan, Île de Praslin, Seychelles', 0, 0),
(47, 5, 189, 0x687474703a2f2f6c6f63616c686f73743a383838382f70726f6a65744167702f696d672f696d616765732832292e6a706567, 'Domaine des rochers', 'La Digue, Seychelles', 0, 0),
(48, 1, 894, 0x687474703a2f2f6c6f63616c686f73743a383838382f70726f6a65744167702f696d672f696d616765732833292e6a706567, 'La Belle Tortue', 'Silhouette, Seychelles', 0, 0),
(49, 1, 8, 0x687474703a2f2f6c6f63616c686f73743a383838382f70726f6a65744167702f696d672f696d61676573202834292e6a706567, 'Carana Beach', 'Seychelles', 0, 0),
(50, 3, 86, 0x687474703a2f2f6c6f63616c686f73743a383838382f70726f6a65744167702f696d672f696d61676573202835292e6a706567, 'The H Resort Beau Vallon Beach', 'Beau Vallon, Seychelles', 0, 0),
(51, 4, 64, 0x687474703a2f2f6c6f63616c686f73743a383838382f70726f6a65744167702f696d672f696d61676573202836292e6a706567, 'L''Hirondelle Self Catering Guest House', 'Seychelles', 0, 0),
(52, 4, 98, 0x687474703a2f2f6c6f63616c686f73743a383838382f70726f6a65744167702f696d672f696d61676573202837292e6a706567, 'Copolia Lodge', 'Forêt Noir Road, Sans Souci, Seychelles', 0, 0),
(53, 3, 86, 0x687474703a2f2f6c6f63616c686f73743a383838382f70726f6a65744167702f696d672f74656c656368617267656d656e74202831292e6a706567, 'Villas de Jardin', '5th June Ave, Seychelles', 0, 0),
(54, 2, 100, 0x687474703a2f2f6c6f63616c686f73743a383838382f70726f6a65744167702f696d672f74656c656368617267656d656e74202832292e6a706567, 'Le Relax Beach House', 'Reunion Island, La Digue, Seychelles', 0, 0),
(55, 1, 78, 0x687474703a2f2f6c6f63616c686f73743a383838382f70726f6a65744167702f696d672f74656c656368617267656d656e74202833292e6a706567, 'Cabanes des Anges Guest House', 'La Digue, Seychelles', 0, 0),
(56, 5, 43, 0x687474703a2f2f6c6f63616c686f73743a383838382f70726f6a65744167702f696d672f74656c656368617267656d656e74202834292e6a706567, 'Le Repaire Boutique Hotel & Restaurant', 'La Digue, Seychelles', 0, 0),
(57, 5, 80, 0x687474703a2f2f6c6f63616c686f73743a383838382f70726f6a65744167702f696d672f74656c656368617267656d656e74202835292e6a706567, 'Côte d''Or Appartements', 'Seychelles', 0, 0),
(58, 2, 89, 0x687474703a2f2f6c6f63616c686f73743a383838382f70726f6a65744167702f696d672f74656c656368617267656d656e74202836292e6a706567, 'Kempinski Seychelles Resort', 'Baie Lazare Mahé Island, Mahe, Seychelles', 0, 0),
(59, 3, 12, 0x687474703a2f2f6c6f63616c686f73743a383838382f70726f6a65744167702f696d672f74656c656368617267656d656e74202837292e6a706567, 'BordMer Villas', 'N Coast Rd, Mare Anglaise, Seychelles', 0, 0),
(60, 5, 79, 0x687474703a2f2f6c6f63616c686f73743a383838382f70726f6a65744167702f696d672f74656c656368617267656d656e742e6a7067, 'Dhevatara Beach Hotel', 'Grand Anse, Praslin, Seychelles', 0, 0),
(61, 4, 70, 0x687474703a2f2f6c6f63616c686f73743a383838382f70726f6a65744167702f696d672f74657272617373652e4a504547, 'Four Seasons Resort', 'Petite Anse, Mahe Island, Seychelles', 0, 0),
(62, 2, 45, 0x687474703a2f2f6c6f63616c686f73743a383838382f70726f6a65744167702f696d672f686f74656c32332e4a504547, 'Constance Ephelia Resort', 'Port Launay Rd, Mahe Island, Seychelles', 0, 0),
(63, 5, 55, 0x687474703a2f2f6c6f63616c686f73743a383838382f70726f6a65744167702f696d672f696d616765732e6a706567, 'Le Domaine de la Réserve', 'Seychelles', 0, 0);


INSERT INTO `TOURISTIC_SITE` (`ID_SITE`, `NAME`, `PRICE`, `PICTURE`, `TYPE`, `ADDRESS`, `LONGITUDE`, `LATITUDE`) VALUES
(1, 'curieuse island', 32, 0x687474703a2f2f6c6f63616c686f73743a383838382f70726f6a65744167702f696d672f63757269657573652d69736c616e642e6a7067, 'leisureSite', 'Île de Praslin, Îles Seychelles', 0, 0),
(2, 'victoria market', 56, 0x687474703a2f2f6c6f63616c686f73743a383838382f70726f6a65744167702f696d672f766963746f7269612d6d61726b65742e6a7067, 'historicalSite', 'Market St , Victoria , Mahé, Seychelles', 0, 0),
(3, 'tempio hindou', 76, 0x687474703a2f2f6c6f63616c686f73743a383838382f70726f6a65744167702f696d672f74656d70696f2d68696e64752e6a7067, 'historicalSite', 'Quincy St, Victoria, Île de Mahé, Îles Seychelles', 0, 0),
(4, 'tower clock', 45, 0x687474703a2f2f6c6f63616c686f73743a383838382f70726f6a65744167702f696d672f746f7765722d636c6f636b2d696e2d766963746f7269612e6a7067, 'leisureSite', 'Avenue de l''Indépendance, Victoria, Mahé, Seychelles', 0, 0),
(5, 'plantation house national', 67, 0x687474703a2f2f6c6f63616c686f73743a383838382f70726f6a65744167702f696d672f706c616e746174696f6e2d686f7573652d6e6174696f6e616c2e6a7067, 'historicalSite', 'La Union- La Digue -Seychelles, La Digue Island La Digue, Îles Seychelles', 0, 0),
(6, 'chateau des mamelles', 34, 0x687474703a2f2f6c6f63616c686f73743a383838382f70726f6a65744167702f696d672f636861746561752d6465732d6d616d656c6c65732e6a7067, 'historicalSite', 'Near the bridge over Mamelles River, Île de Mahé, Îles Seychelles', 0, 0),
(7, 'eglise de saint-roch', 78, 0x687474703a2f2f6c6f63616c686f73743a383838382f70726f6a65744167702f696d672f65676c6973652d64652d7361696e742d726f63682e6a7067, 'historicalSite', 'Bel Ombre , Mahé, Seychelles', 0, 0),
(8, 'cathedral of our lady', 54, 0x687474703a2f2f6c6f63616c686f73743a383838382f70726f6a65744167702f696d672f63617468656472616c2d6f662d6f75722d6c6164792e6a7067, 'historicalSite', 'Diocèse de Port Victoria, Olivier Maradan Street, Victoria, Mahe , Mahé PO Box 43 , Seychelles', 0, 0),
(9, 'sunny trail guide', 48, 0x687474703a2f2f6c6f63616c686f73743a383838382f70726f6a65744167702f696d672f73756e6e792d747261696c2d67756964652d707269766174652e6a7067, 'leisureSite', 'La Passe, La Digue Island, Îles Seychelles', 0, 0),
(10, 'kenwyn house', 13, 0x687474703a2f2f6c6f63616c686f73743a383838382f70726f6a65744167702f696d672f6b656e77796e2d686f7573652e6a7067, 'historicalSite', 'Francis Rachel Street, Victoria, Île de Mahé, Îles Seychelles', 0, 0),
(11, 'rita''s art sudio gallery', 87, 0x687474703a2f2f6c6f63616c686f73743a383838382f70726f6a65744167702f696d672f726974612d732d6172742d737564696f2d67616c6c6572792e6a7067, 'leisureSite', 'Anse Volbert Praslin Seychelles , Île de Praslin, Seychelles', 0, 0),
(12, 'domaine de val-des-pres', 5, 0x687474703a2f2f6c6f63616c686f73743a383838382f70726f6a65744167702f696d672f646f6d61696e652d64652d76616c2d6465732d707265732e6a7067, 'leisureSite', 'Au Cap, Île de Praslin 1383, Îles Seychelles', 0, 0),
(13, 'Gran Kaz Entertainment Center', 64, 0x687474703a2f2f6c6f63616c686f73743a383838382f70726f6a65744167702f696d672f6765746c7374642d70726f70657274792d70686f746f2e6a7067, 'leisureSite', 'Francis rachel street | near National Library, Victoria, Île de Mahé, Îles Seychelles', 0, 0),
(14, 'praslin museum', 32, 0x687474703a2f2f6c6f63616c686f73743a383838382f70726f6a65744167702f696d672f707261736c696e2d6d757365756d2e6a7067, 'leisureSite', 'Route de Cote d''Or, Île de Praslin, Îles Seychelles', 0, 0),
(15, 'coco island', 53, 0x687474703a2f2f6c6f63616c686f73743a383838382f70726f6a65744167702f696d672f636f636f2d69736c616e642e6a7067, 'leisureSite', 'Coco Island, La Digue Island, Îles Seychelles', 0, 0),
(16, 'botanic garden mahe', 15, 0x687474703a2f2f6c6f63616c686f73743a383838382f70726f6a65744167702f696d672f626f74616e69632d67617264656e2d6d6168652e6a7067, 'historicalSite', 'National Botanic Gardens Foundation \r\nPO Box 148, Victoria, Mahé, Seychelles \r\nMahé / Seychelles', 0, 0),
(17, 'Diving and Snorkeling in Seychelles', 90, 0x687474703a2f2f6c6f63616c686f73743a383838382f70726f6a65744167702f696d672f692d70657363692e6a7067, 'leisureSite', 'Anse Volbert, Île de Praslin, Îles Seychelles', 0, 0),
(18, 'Spas to Beau Vallon', 67, 0x687474703a2f2f6c6f63616c686f73743a383838382f70726f6a65744167702f696d672f7065707065726d696e742d6265617574792d616e64202831292e6a7067, 'leisureSite', 'St Louis Rd, Beau Vallon, Île de Mahé, Îles Seychelles', 0, 0),
(19, 'enjoying the nectar credit', 85, 0x687474703a2f2f6c6f63616c686f73743a383838382f70726f6a65744167702f696d672f656e6a6f79696e672d7468652d6e65637461722d6372656469742e6a7067, 'historicalSite', 'Domaine de L''enfoncement | Anse Royale, Mahe, Île de Mahé, Îles Seychelles', 0, 0),
(20, 'seychelles national museum', 47, 0x687474703a2f2f6c6f63616c686f73743a383838382f70726f6a65744167702f696d672f7365796368656c6c65732d6e6174696f6e616c2d6d757365756d2e6a7067, 'historicalSite', 'Avenue de l'' Indépendance à proximité de la rue Albert , Victoria , Mahé, Seychelles', 0, 0);


INSERT INTO `transport` (`ID_TRANSPORT`, `MODE`, `DURATION`) VALUES
(1, 'autobus', 60),
(2, 'boat', 90),
(3, 'autobus', 30),
(4, 'autobus', 30),
(5, 'boat', 60),
(6, 'autobus', 120),
(7, 'boat', 45),
(8, 'boat', 15),
(9, 'boat', 20),
(10, 'autobus', 30),
(11, 'boat', 75),
(12, 'autobus', 75),
(13, 'autobus', 20),
(14, 'boat', 50),
(15, 'boat', 120),
(16, 'autobus', 35),
(17, 'autobus', 10),
(18, 'boat', 100),
(19, 'boat', 40),
(20, 'autobus', 23);