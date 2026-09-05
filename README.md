# Kafka Trainning

# Order Management System

Sistema de gerenciamento de pedidos baseado em microsserviços
e arquitetura orientada a eventos.

## Event Flow

O fluxo principal do pedido é baseado em eventos publicados
e consumidos através do Apache Kafka.

```text
order-created
      ↓
payment-approved
      ↓
order-separated
      ↓
order-invoiced
      ↓
order-shipped
      ↓
order-delivered
```

## Fluxo do Sistema

![Fluxo do Sistema](docs/img/Kafka%20Design.png)

## Arquitetura do Sistema completa

![Arquitetura do Sistema](docs/img/Kafka%20Design%20completo.png)