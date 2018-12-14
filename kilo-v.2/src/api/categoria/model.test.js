import { Categoria } from '.'

let categoria

beforeEach(async () => {
  categoria = await Categoria.create({ nombre: 'test', campaigne_id: 'test' })
})

describe('view', () => {
  it('returns simple view', () => {
    const view = categoria.view()
    expect(typeof view).toBe('object')
    expect(view.id).toBe(categoria.id)
    expect(view.nombre).toBe(categoria.nombre)
    expect(view.campaigne_id).toBe(categoria.campaigne_id)
    expect(view.createdAt).toBeTruthy()
    expect(view.updatedAt).toBeTruthy()
  })

  it('returns full view', () => {
    const view = categoria.view(true)
    expect(typeof view).toBe('object')
    expect(view.id).toBe(categoria.id)
    expect(view.nombre).toBe(categoria.nombre)
    expect(view.campaigne_id).toBe(categoria.campaigne_id)
    expect(view.createdAt).toBeTruthy()
    expect(view.updatedAt).toBeTruthy()
  })
})
