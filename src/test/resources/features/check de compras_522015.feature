#Auto generated Octane revision tag
@TID522015REV0.2.0
Feature: Gerenciamento de Usuarios

	Scenario Outline: Verifica navigation links no Portal de Ofertas
		Given "<user>" esta no portal de ofertas
		When  clica no link "<link>"
		Then pagina mostrada com status "<status>"

		Examples:
			| user  | link     | status |
			| admin | produtos | OK     |
			| Homer | servicos | OK     |
			| Homer | conta    | NOK    |