ALTER TABLE chefia AUTO_INCREMENT = 1;
ALTER TABLE controle AUTO_INCREMENT = 1;
ALTER TABLE equipamentos AUTO_INCREMENT = 1;
ALTER TABLE orgao AUTO_INCREMENT = 1;
ALTER TABLE tecnico AUTO_INCREMENT = 1;
ALTER TABLE tipo_equipamentos AUTO_INCREMENT = 1;

INSERT INTO TABLE (COLUMNS) VALUES (?,?,?,?,?);


//SELECT UTILIZADO PARA FAZER A CONSULTA
Select c.nome, (o.nome_orgao) as orgao FROM chefias c, orgaos o
Where c.matricula='120' AND c.cod_orgao= o.id;