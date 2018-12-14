import { Router } from 'express'
import { middleware as query } from 'querymen'
import { middleware as body } from 'bodymen'
import { create, index, show, update, destroy } from './controller'
import { schema } from './model'
export Donativo, { schema } from './model'

const router = new Router()
const { cantidad, usuario_id, categoria_id } = schema.tree

/**
 * @api {post} /donativos Create donativo
 * @apiName CreateDonativo
 * @apiGroup Donativo
 * @apiParam cantidad Donativo's cantidad.
 * @apiParam usuario_id Donativo's usuario_id.
 * @apiParam categoria_id Donativo's categoria_id.
 * @apiSuccess {Object} donativo Donativo's data.
 * @apiError {Object} 400 Some parameters may contain invalid values.
 * @apiError 404 Donativo not found.
 */
router.post('/',
  body({ cantidad, usuario_id, categoria_id }),
  create)

/**
 * @api {get} /donativos Retrieve donativos
 * @apiName RetrieveDonativos
 * @apiGroup Donativo
 * @apiUse listParams
 * @apiSuccess {Number} count Total amount of donativos.
 * @apiSuccess {Object[]} rows List of donativos.
 * @apiError {Object} 400 Some parameters may contain invalid values.
 */
router.get('/',
  query(),
  index)

/**
 * @api {get} /donativos/:id Retrieve donativo
 * @apiName RetrieveDonativo
 * @apiGroup Donativo
 * @apiSuccess {Object} donativo Donativo's data.
 * @apiError {Object} 400 Some parameters may contain invalid values.
 * @apiError 404 Donativo not found.
 */
router.get('/:id',
  show)

/**
 * @api {put} /donativos/:id Update donativo
 * @apiName UpdateDonativo
 * @apiGroup Donativo
 * @apiParam cantidad Donativo's cantidad.
 * @apiParam usuario_id Donativo's usuario_id.
 * @apiParam categoria_id Donativo's categoria_id.
 * @apiSuccess {Object} donativo Donativo's data.
 * @apiError {Object} 400 Some parameters may contain invalid values.
 * @apiError 404 Donativo not found.
 */
router.put('/:id',
  body({ cantidad, usuario_id, categoria_id }),
  update)

/**
 * @api {delete} /donativos/:id Delete donativo
 * @apiName DeleteDonativo
 * @apiGroup Donativo
 * @apiSuccess (Success 204) 204 No Content.
 * @apiError 404 Donativo not found.
 */
router.delete('/:id',
  destroy)

export default router
