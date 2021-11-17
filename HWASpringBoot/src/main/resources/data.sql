INSERT INTO boat_clubs (boat_club_name, address, boat_club_code, head_coach_first_name, head_coach_surname)
VALUES ('London Rowing Club', 
		'London Rowing Club, Embankment, Putney, London, SW15 1LB'
		'LRC'
		'Stuart'
		'Heap'),
		('Tideway Scullers School'
		'Tideway Scullers School, Dan Mason Drive, Dukes Meadow, W4 2SH',
		'TSS',
		'Kieran',
		'Clarke');

INSERT INTO boats (boat_type, boat_company, avg_crew_weight, rigger_material, is_wing_rigger, boat_club_id)
VALUES ('8+', 'Empacher', '95', 'Carbon', 'T', '1'),
	   ('4-', 'Filippi Boats', '83', 'Aluminium', 'T', '1');