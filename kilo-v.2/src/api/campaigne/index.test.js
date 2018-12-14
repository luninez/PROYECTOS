import request from 'supertest'
import { apiRoot } from '../../config'
import express from '../../services/express'
import routes, { Campaigne } from '.'

const app = () => express(apiRoot, routes)

let campaigne

beforeEach(async () => {
  campaigne = await Campaigne.create({})
})

test('POST /campaignes 201', async () => {
  const { status, body } = await request(app())
    .post(`${apiRoot}`)
    .send({ nombre: 'test', usuarios: 'test', categorias: 'test' })
  expect(status).toBe(201)
  expect(typeof body).toEqual('object')
  expect(body.nombre).toEqual('test')
  expect(body.usuarios).toEqual('test')
  expect(body.categorias).toEqual('test')
})

test('GET /campaignes 200', async () => {
  const { status, body } = await request(app())
    .get(`${apiRoot}`)
  expect(status).toBe(200)
  expect(Array.isArray(body.rows)).toBe(true)
  expect(Number.isNaN(body.count)).toBe(false)
})

test('GET /campaignes/:id 200', async () => {
  const { status, body } = await request(app())
    .get(`${apiRoot}/${campaigne.id}`)
  expect(status).toBe(200)
  expect(typeof body).toEqual('object')
  expect(body.id).toEqual(campaigne.id)
})

test('GET /campaignes/:id 404', async () => {
  const { status } = await request(app())
    .get(apiRoot + '/123456789098765432123456')
  expect(status).toBe(404)
})

test('PUT /campaignes/:id 200', async () => {
  const { status, body } = await request(app())
    .put(`${apiRoot}/${campaigne.id}`)
    .send({ nombre: 'test', usuarios: 'test', categorias: 'test' })
  expect(status).toBe(200)
  expect(typeof body).toEqual('object')
  expect(body.id).toEqual(campaigne.id)
  expect(body.nombre).toEqual('test')
  expect(body.usuarios).toEqual('test')
  expect(body.categorias).toEqual('test')
})

test('PUT /campaignes/:id 404', async () => {
  const { status } = await request(app())
    .put(apiRoot + '/123456789098765432123456')
    .send({ nombre: 'test', usuarios: 'test', categorias: 'test' })
  expect(status).toBe(404)
})

test('DELETE /campaignes/:id 204', async () => {
  const { status } = await request(app())
    .delete(`${apiRoot}/${campaigne.id}`)
  expect(status).toBe(204)
})

test('DELETE /campaignes/:id 404', async () => {
  const { status } = await request(app())
    .delete(apiRoot + '/123456789098765432123456')
  expect(status).toBe(404)
})
