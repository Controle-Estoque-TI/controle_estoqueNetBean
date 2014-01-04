Software desenvolvido para a SMAGP 
==================================
###    no NetBeans com Mysql
============================

Controle Estoque - README
==========================

## MVC

| Model                      | View                                                           | Controller               |
|----------------------------|----------------------------------------------------------------|--------------------------|
| Controle                   | *GUIControle*                                                  | *DAOFactory*(ControleDAO)|
| Equipamentos               | GuiEquipamentos(*GUIListEquipamentos* - *GUINovoEquipamento*)  | *DAOFactory*(EquipamentosDAO)
| Orgaos                     | GUIOrgaos                                                      | *DAOFactory*(OrgaosDAO)  |
| *Funcionario*(Tecnico)     | *GUITecnico*                                                   | *DAOFactory*(TecnicoDAO) |
| *Funcionario*(Chefia)      | *GUIChefia*                                                    | *DAOFactory*(ChefiaDAO)  |


Objetos criados para personalizar os campos de texto


    $ JTextFieldOnlyNumbers.java
    $ Input_Field_Controller.java

Objeto criado para criar uma tabela para a exibição de dados


    $ ModeloTabela.java

