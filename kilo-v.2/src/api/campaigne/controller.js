import { success, notFound } from '../../services/response/'
import { Campaigne } from '.'

export const create = ({ bodymen: { body } }, res, next) =>
  Campaigne.create(body)
    .then((campaigne) => campaigne.view(true))
    .then(success(res, 201))
    .catch(next)

export const index = ({ querymen: { query, select, cursor } }, res, next) =>
  Campaigne.count(query)
    .then(count => Campaigne.find(query, select, cursor)
      .then((campaignes) => ({
        count,
        rows: campaignes.map((campaigne) => campaigne.view())
      }))
    )
    .then(success(res))
    .catch(next)

export const show = ({ params }, res, next) =>
  Campaigne.findById(params.id)
    .then(notFound(res))
    .then((campaigne) => campaigne ? campaigne.view() : null)
    .then(success(res))
    .catch(next)

export const update = ({ bodymen: { body }, params }, res, next) =>
  Campaigne.findById(params.id)
    .then(notFound(res))
    .then((campaigne) => campaigne ? Object.assign(campaigne, body).save() : null)
    .then((campaigne) => campaigne ? campaigne.view(true) : null)
    .then(success(res))
    .catch(next)

export const destroy = ({ params }, res, next) =>
  Campaigne.findById(params.id)
    .then(notFound(res))
    .then((campaigne) => campaigne ? campaigne.remove() : null)
    .then(success(res, 204))
    .catch(next)
