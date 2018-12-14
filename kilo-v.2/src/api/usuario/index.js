import { Router } from 'express'
import { middleware as query } from 'querymen'
import { middleware as body } from 'bodymen'
import { create, index, show, update, destroy } from './controller'
import { schema } from './model'
export Usuario, { schema } from './model'

const router = new Router()
const { token, nombre, email, password } = schema.tree

/**
 * @api {post} /usuarios Create usuario
 * @apiName CreateUsuario
 * @apiGroup Usuario
 * @apiParam token Usuario's token.
 * @apiParam nombre Usuario's nombre.
 * @apiParam email Usuario's email.
 * @apiParam password Usuario's password.
 * @apiSuccess {Object} usuario Usuario's data.
 * @apiError {Object} 400 Some parameters may contain invalid values.
 * @apiError 404 Usuario not found.
 */
router.post('/',
  body({ token, nombre, email, password }),
  create)

/**
 * @api {get} /usuarios Retrieve usuarios
 * @apiName RetrieveUsuarios
 * @apiGroup Usuario
 * @apiUse listParams
 * @apiSuccess {Number} count Total amount of usuarios.
 * @apiSuccess {Object[]} rows List of usuarios.
 * @apiError {Object} 400 Some parameters may contain invalid values.
 */
router.get('/',
  query(),
  index)

/**
 * @api {get} /usuarios/:id Retrieve usuario
 * @apiName RetrieveUsuario
 * @apiGroup Usuario
 * @apiSuccess {Object} usuario Usuario's data.
 * @apiError {Object} 400 Some parameters may contain invalid values.
 * @apiError 404 Usuario not found.
 */
router.get('/:id',
  show)

/**
 * @api {put} /usuarios/:id Update usuario
 * @apiName UpdateUsuario
 * @apiGroup Usuario
 * @apiParam token Usuario's token.
 * @apiParam nombre Usuario's nombre.
 * @apiParam email Usuario's email.
 * @apiParam password Usuario's password.
 * @apiSuccess {Object} usuario Usuario's data.
 * @apiError {Object} 400 Some parameters may contain invalid values.
 * @apiError 404 Usuario not found.
 */
router.put('/:id',
  body({ token, nombre, email, password }),
  update)

/**
 * @api {delete} /usuarios/:id Delete usuario
 * @apiName DeleteUsuario
 * @apiGroup Usuario
 * @apiSuccess (Success 204) 204 No Content.
 * @apiError 404 Usuario not found.
 */
router.delete('/:id',
  destroy)

export default router
