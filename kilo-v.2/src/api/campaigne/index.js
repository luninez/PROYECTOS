import { Router } from 'express'
import { middleware as query } from 'querymen'
import { middleware as body } from 'bodymen'
import { create, index, show, update, destroy } from './controller'
import { schema } from './model'
export Campaigne, { schema } from './model'

const router = new Router()
const { nombre, usuarios, categorias } = schema.tree

/**
 * @api {post} /campaignes Create campaigne
 * @apiName CreateCampaigne
 * @apiGroup Campaigne
 * @apiParam nombre Campaigne's nombre.
 * @apiParam usuarios Campaigne's usuarios.
 * @apiParam categorias Campaigne's categorias.
 * @apiSuccess {Object} campaigne Campaigne's data.
 * @apiError {Object} 400 Some parameters may contain invalid values.
 * @apiError 404 Campaigne not found.
 */
router.post('/',
  body({ nombre, usuarios, categorias }),
  create)

/**
 * @api {get} /campaignes Retrieve campaignes
 * @apiName RetrieveCampaignes
 * @apiGroup Campaigne
 * @apiUse listParams
 * @apiSuccess {Number} count Total amount of campaignes.
 * @apiSuccess {Object[]} rows List of campaignes.
 * @apiError {Object} 400 Some parameters may contain invalid values.
 */
router.get('/',
  query(),
  index)

/**
 * @api {get} /campaignes/:id Retrieve campaigne
 * @apiName RetrieveCampaigne
 * @apiGroup Campaigne
 * @apiSuccess {Object} campaigne Campaigne's data.
 * @apiError {Object} 400 Some parameters may contain invalid values.
 * @apiError 404 Campaigne not found.
 */
router.get('/:id',
  show)

/**
 * @api {put} /campaignes/:id Update campaigne
 * @apiName UpdateCampaigne
 * @apiGroup Campaigne
 * @apiParam nombre Campaigne's nombre.
 * @apiParam usuarios Campaigne's usuarios.
 * @apiParam categorias Campaigne's categorias.
 * @apiSuccess {Object} campaigne Campaigne's data.
 * @apiError {Object} 400 Some parameters may contain invalid values.
 * @apiError 404 Campaigne not found.
 */
router.put('/:id',
  body({ nombre, usuarios, categorias }),
  update)

/**
 * @api {delete} /campaignes/:id Delete campaigne
 * @apiName DeleteCampaigne
 * @apiGroup Campaigne
 * @apiSuccess (Success 204) 204 No Content.
 * @apiError 404 Campaigne not found.
 */
router.delete('/:id',
  destroy)

export default router
