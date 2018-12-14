import { success, notFound } from '../../services/response/'
import { Donativo } from '.'

export const create = ({ bodymen: { body } }, res, next) =>
  Donativo.create(body)
    .then((donativo) => donativo.view(true))
    .then(success(res, 201))
    .catch(next)

export const index = ({ querymen: { query, select, cursor } }, res, next) =>
  Donativo.count(query)
    .then(count => Donativo.find(query, select, cursor)
      .then((donativos) => ({
        count,
        rows: donativos.map((donativo) => donativo.view())
      }))
    )
    .then(success(res))
    .catch(next)

export const show = ({ params }, res, next) =>
  Donativo.findById(params.id)
    .then(notFound(res))
    .then((donativo) => donativo ? donativo.view() : null)
    .then(success(res))
    .catch(next)

export const update = ({ bodymen: { body }, params }, res, next) =>
  Donativo.findById(params.id)
    .then(notFound(res))
    .then((donativo) => donativo ? Object.assign(donativo, body).save() : null)
    .then((donativo) => donativo ? donativo.view(true) : null)
    .then(success(res))
    .catch(next)

export const destroy = ({ params }, res, next) =>
  Donativo.findById(params.id)
    .then(notFound(res))
    .then((donativo) => donativo ? donativo.remove() : null)
    .then(success(res, 204))
    .catch(next)
