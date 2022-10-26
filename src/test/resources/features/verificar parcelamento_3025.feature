#Auto generated Octane revision tag
@TID3025REV0.2.0
Feature: Pagamento
	Scenario: verificar opcoes de parcelamento
		Given cliente efetuou compra
		When  selecionou parcelamento  
		Then  compra parcelada  
