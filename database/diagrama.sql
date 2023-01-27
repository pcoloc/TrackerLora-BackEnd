-- DROP SCHEMA public;

CREATE SCHEMA public AUTHORIZATION root;

-- DROP SEQUENCE public.hibernate_sequence;

CREATE SEQUENCE public.hibernate_sequence
	INCREMENT BY 1
	MINVALUE 1
	MAXVALUE 9223372036854775807
	START 1
	CACHE 1
	NO CYCLE;-- public.api_things_network definition

-- Drop table

-- DROP TABLE public.api_things_network;

CREATE TABLE public.api_things_network (
	uuid varchar(255) NOT NULL,
	client_uuid varchar(255) NULL,
	"name" varchar(255) NULL,
	CONSTRAINT api_things_network_pkey PRIMARY KEY (uuid)
);


-- public.apis definition

-- Drop table

-- DROP TABLE public.apis;

CREATE TABLE public.apis (
	uuid varchar(255) NOT NULL,
	api_key varchar(255) NULL,
	description varchar(255) NULL,
	is_active bool NOT NULL,
	"name" varchar(255) NULL,
	owner_uuid varchar(255) NULL,
	uuid_client varchar(255) NULL,
	client_uuid varchar(255) NULL,
	CONSTRAINT apis_pkey PRIMARY KEY (uuid)
);


-- public.clients definition

-- Drop table

-- DROP TABLE public.clients;

CREATE TABLE public.clients (
	uuid varchar(255) NOT NULL,
	api_key varchar(255) NULL,
	color varchar(255) NULL,
	description varchar(255) NULL,
	is_active bool NOT NULL,
	is_public bool NOT NULL,
	is_router bool NOT NULL,
	"name" varchar(255) NULL,
	owner_uuid varchar(255) NULL,
	added_at date NULL,
	ttn_id varchar(255) NULL,
	CONSTRAINT clients_pkey PRIMARY KEY (uuid)
);


-- public.gateways definition

-- Drop table

-- DROP TABLE public.gateways;

CREATE TABLE public.gateways (
	id int4 NOT NULL,
	altitude float4 NULL,
	antenna_index int4 NULL,
	channel int4 NULL,
	gtw_eui varchar(255) NULL,
	gtw_id varchar(255) NULL,
	latitude float4 NULL,
	location_accuracy float4 NULL,
	location_source varchar(255) NULL,
	longitude float4 NULL,
	network_id varchar(255) NULL,
	rssi float8 NULL,
	snr float8 NULL,
	"time" int8 NULL,
	"timestamp" int8 NULL,
	metros int4 NULL,
	CONSTRAINT gateways_pkey PRIMARY KEY (id)
);


-- public.locations definition

-- Drop table

-- DROP TABLE public.locations;

CREATE TABLE public.locations (
	id int8 NOT NULL,
	"date" timestamp NULL,
	latitud varchar(255) NULL,
	longitud varchar(255) NULL,
	CONSTRAINT locations_pkey PRIMARY KEY (id)
);


-- public.monitors definition

-- Drop table

-- DROP TABLE public.monitors;

CREATE TABLE public.monitors (
	uuid varchar(255) NOT NULL,
	description varchar(255) NULL,
	ip varchar(255) NULL,
	is_active bool NOT NULL,
	"name" varchar(255) NULL,
	owner_uuid varchar(255) NULL,
	CONSTRAINT monitors_pkey PRIMARY KEY (uuid)
);


-- public.power definition

-- Drop table

-- DROP TABLE public.power;

CREATE TABLE public.power (
	id int4 NOT NULL,
	device_power int4 NULL,
	CONSTRAINT power_pkey PRIMARY KEY (id)
);


-- public.relations definition

-- Drop table

-- DROP TABLE public.relations;

CREATE TABLE public.relations (
	uuid varchar(255) NOT NULL,
	client1uuid varchar(255) NULL,
	client2uuid varchar(255) NULL,
	"date" timestamp NULL,
	lat1 varchar(255) NULL,
	lat2 varchar(255) NULL,
	lon1 varchar(255) NULL,
	lon2 varchar(255) NULL,
	CONSTRAINT relations_pkey PRIMARY KEY (uuid)
);


-- public.shodan definition

-- Drop table

-- DROP TABLE public.shodan;

CREATE TABLE public.shodan (
	uuid varchar(255) NOT NULL,
	api_key varchar(255) NULL,
	is_active bool NOT NULL,
	"name" varchar(255) NULL,
	owner_uuid varchar(255) NULL,
	CONSTRAINT shodan_pkey PRIMARY KEY (uuid)
);


-- public.statsttn definition

-- Drop table

-- DROP TABLE public.statsttn;

CREATE TABLE public.statsttn (
	uuid varchar(255) NOT NULL,
	client_id varchar(255) NULL,
	connected_at timestamp NULL,
	downlink_count int4 NULL,
	last_downlink_received_at timestamp NULL,
	last_uplink_received_at timestamp NULL,
	protocol varchar(255) NULL,
	count varchar(255) NULL,
	max varchar(255) NULL,
	median varchar(255) NULL,
	min varchar(255) NULL,
	downlink_utilization_limit varchar(255) NULL,
	max_frequency varchar(255) NULL,
	uplink_count int4 NULL,
	CONSTRAINT statsttn_pkey PRIMARY KEY (uuid)
);


-- public.ttn_mapper_data definition

-- Drop table

-- DROP TABLE public.ttn_mapper_data;

CREATE TABLE public.ttn_mapper_data (
	id int4 NOT NULL,
	accuracy_meters float4 NULL,
	accuracy_source varchar(255) NULL,
	altitude float4 NULL,
	app_id varchar(255) NULL,
	bandwidth int4 NULL,
	coding_rate varchar(255) NULL,
	counter int4 NULL,
	dev_id varchar(255) NULL,
	frequency int4 NULL,
	latitude float4 NULL,
	longitude float4 NULL,
	modulation varchar(255) NULL,
	network_id varchar(255) NULL,
	port int4 NULL,
	spreading_factor int4 NULL,
	"time" int8 NULL,
	user_agent varchar(255) NULL,
	user_id varchar(255) NULL,
	potencia int4 NULL,
	metros int4 NULL,
	CONSTRAINT ttn_mapper_data_pkey PRIMARY KEY (id)
);


-- public.ttnmapper definition

-- Drop table

-- DROP TABLE public.ttnmapper;

CREATE TABLE public.ttnmapper (
	id int4 NOT NULL,
	accuracy_meters float4 NOT NULL,
	altitude float4 NOT NULL,
	antenna_index int4 NULL,
	bandwidth int8 NOT NULL,
	channel_index int4 NULL,
	coding_rate varchar(255) NULL,
	dev_id varchar(255) NULL,
	fcount int4 NULL,
	fport int4 NULL,
	frequency int8 NOT NULL,
	gateway_altitude int8 NOT NULL,
	gateway_id varchar(255) NULL,
	gateway_latitude float4 NOT NULL,
	gateway_longitude float4 NOT NULL,
	gateway_time int8 NOT NULL,
	gateway_timestamp int8 NOT NULL,
	latitude float4 NOT NULL,
	longitude float4 NOT NULL,
	rssi int4 NULL,
	"session" varchar(255) NULL,
	snr int4 NULL,
	spreading_factor int8 NOT NULL,
	"time" int8 NOT NULL,
	uid int4 NULL,
	CONSTRAINT ttnmapper_pkey PRIMARY KEY (id)
);


-- public.users definition

-- Drop table

-- DROP TABLE public.users;

CREATE TABLE public.users (
	uuid varchar(255) NOT NULL,
	email varchar(255) NULL,
	first_name varchar(255) NULL,
	last_name varchar(255) NULL,
	"password" varchar(255) NULL,
	"role" varchar(255) NULL,
	username varchar(255) NULL,
	user_name varchar(255) NULL,
	CONSTRAINT users_pkey PRIMARY KEY (uuid)
);


-- public.clients_locations definition

-- Drop table

-- DROP TABLE public.clients_locations;

CREATE TABLE public.clients_locations (
	client_uuid varchar(255) NOT NULL,
	locations_id int8 NOT NULL,
	CONSTRAINT uk_bop0m5bnv605n0t1tj394u9o3 UNIQUE (locations_id),
	CONSTRAINT fkefdwf64odfqbcm58krlcjkaup FOREIGN KEY (client_uuid) REFERENCES public.clients(uuid),
	CONSTRAINT fkn9wrqkh7i41d8gide7x52w8xq FOREIGN KEY (locations_id) REFERENCES public.locations(id)
);


-- public.ttn_mapper_data_gateways definition

-- Drop table

-- DROP TABLE public.ttn_mapper_data_gateways;

CREATE TABLE public.ttn_mapper_data_gateways (
	ttn_mapper_data_id int4 NOT NULL,
	gateways_id int4 NOT NULL,
	CONSTRAINT uk_oguid96xg37thg6tiboudtxya UNIQUE (gateways_id),
	CONSTRAINT fkfgngsslxs5obasmx1ucnfwb8n FOREIGN KEY (gateways_id) REFERENCES public.gateways(id),
	CONSTRAINT fkjec3d8rymn99hjyoeo34me79x FOREIGN KEY (ttn_mapper_data_id) REFERENCES public.ttn_mapper_data(id)
);
