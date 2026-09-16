# Fluxo de Estoque e Logística

## Estoque

A tabela `products` terá:

- `id`
- `name`
- `available_quantity`
- `reserved_quantity`

## Fluxo

Quando o pagamento for aprovado, o Inventory Service recebe o evento `payment-approved`.

O produto é retirado da quantidade disponível e passa para a quantidade reservada.

### Exemplo

Estoque inicial:

```text
available = 10
reserved  = 0
```

Após `payment-approved` para um pedido de 2 unidades:

```text
available = 8
reserved  = 2
```

Os produtos permanecem reservados enquanto o pedido passa pelo processo logístico.

## Processo Logístico

```text
payment-approved
       ↓
RESERVADO
       ↓
SEPARAÇÃO
       ↓
CARREGAMENTO
       ↓
FATURAMENTO
       ↓
ENVIO
       ↓
ENTREGUE
```

## Tabela Logistics

A tabela `logistics` terá inicialmente:

- `id`
- `order_id`
- `status`

Status:

```text
RESERVADO
SEPARAÇÃO
CARREGAMENTO
FATURAMENTO
ENVIO
ENTREGUE
```

## Futuro: pagamento recusado

Caso futuramente o pagamento seja recusado, o evento `payment-rejected` poderá devolver a quantidade reservada para o estoque disponível.

Exemplo:

```text
available = 8
reserved  = 2
```

Após `payment-rejected`:

```text
available = 10
reserved  = 0
```

## Objetivo atual

Implementar apenas o fluxo normal, sem validações ou tratamento de erros.

A lógica de validação de estoque, pagamento recusado e outras situações será adicionada posteriormente.
