import { Campaigne } from '.'

let campaigne

beforeEach(async () => {
  campaigne = await Campaigne.create({ nombre: 'test', usuarios: 'test', categorias: 'test' })
})

describe('view', () => {
  it('returns simple view', () => {
    const view = campaigne.view()
    expect(typeof view).toBe('object')
    expect(view.id).toBe(campaigne.id)
    expect(view.nombre).toBe(campaigne.nombre)
    expect(view.usuarios).toBe(campaigne.usuarios)
    expect(view.categorias).toBe(campaigne.categorias)
    expect(view.createdAt).toBeTruthy()
    expect(view.updatedAt).toBeTruthy()
  })

  it('returns full view', () => {
    const view = campaigne.view(true)
    expect(typeof view).toBe('object')
    expect(view.id).toBe(campaigne.id)
    expect(view.nombre).toBe(campaigne.nombre)
    expect(view.usuarios).toBe(campaigne.usuarios)
    expect(view.categorias).toBe(campaigne.categorias)
    expect(view.createdAt).toBeTruthy()
    expect(view.updatedAt).toBeTruthy()
  })
})
