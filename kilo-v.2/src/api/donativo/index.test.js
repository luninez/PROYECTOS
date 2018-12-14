import request from 'supertest'
import { apiRoot } from '../../config'
import express from '../../services/express'
import routes, { Donativo } from '.'

const app = () => express(apiRoot, routes)

let donativo

beforeEach(async () => {
  donativo = await Donativo.create({})
})

test('POST /donativos 201', async () => {
  const { status, body } = await request(app())
    .post(`${apiRoot}`)
    .send({ cantidad: 'test', usuario_id: 'test', categoria_id: 'test' })
  expect(status).toBe(201)
  expect(typeof body).toEqual('object')
  expect(body.cantidad).toEqual('test')
  expect(body.usuario_id).toEqual('test')
  expect(body.categoria_id).toEqual('test')
})

test('GET /donativos 200', async () => {
  const { status, body } = await request(app())
    .get(`${apiRoot}`)
  expect(status).toBe(200)
  expect(Array.isArray(body.rows)).toBe(true)
  expect(Number.isNaN(body.count)).toBe(false)
})

test('GET /donativos/:id 200', async () => {
  const { status, body } = await request(app())
    .get(`${apiRoot}/${donativo.id}`)
  expect(status).toBe(200)
  expect(typeof body).toEqual('object')
  expect(body.id).toEqual(donativo.id)
})

test('GET /donativos/:id 404', async () => {
  const { status } = await request(app())
    .get(apiRoot + '/123456789098765432123456')
  expect(status).toBe(404)
})

test('PUT /donativos/:id 200', async () => {
  const { status, body } = await request(app())
    .put(`${apiRoot}/${donativo.id}`)
    .send({ cantidad: 'test', usuario_id: 'test', categoria_id: 'test' })
  expect(status).toBe(200)
  expect(typeof body).toEqual('object')
  expect(body.id).toEqual(donativo.id)
  expect(body.cantidad).toEqual('test')
  expect(body.usuario_id).toEqual('test')
  expect(body.categoria_id).toEqual('test')
})

test('PUT /donativos/:id 404', async () => {
  const { status } = await request(app())
    .put(apiRoot + '/123456789098765432123456')
    .send({ cantidad: 'test', usuario_id: 'test', categoria_id: 'test' })
  expect(status).toBe(404)
})

test('DELETE /donativos/:id 204', async () => {
  const { status } = await request(app())
    .delete(`${apiRoot}/${donativo.id}`)
  expect(status).toBe(204)
})

test('DELETE /donativos/:id 404', async () => {
  const { status } = await request(app())
    .delete(apiRoot + '/123456789098765432123456')
  expect(status).toBe(404)
})
