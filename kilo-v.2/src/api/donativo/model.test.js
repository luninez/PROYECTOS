import { Donativo } from '.'

let donativo

beforeEach(async () => {
  donativo = await Donativo.create({ cantidad: 'test', usuario_id: 'test', categoria_id: 'test' })
})

describe('view', () => {
  it('returns simple view', () => {
    const view = donativo.view()
    expect(typeof view).toBe('object')
    expect(view.id).toBe(donativo.id)
    expect(view.cantidad).toBe(donativo.cantidad)
    expect(view.usuario_id).toBe(donativo.usuario_id)
    expect(view.categoria_id).toBe(donativo.categoria_id)
    expect(view.createdAt).toBeTruthy()
    expect(view.updatedAt).toBeTruthy()
  })

  it('returns full view', () => {
    const view = donativo.view(true)
    expect(typeof view).toBe('object')
    expect(view.id).toBe(donativo.id)
    expect(view.cantidad).toBe(donativo.cantidad)
    expect(view.usuario_id).toBe(donativo.usuario_id)
    expect(view.categoria_id).toBe(donativo.categoria_id)
    expect(view.createdAt).toBeTruthy()
    expect(view.updatedAt).toBeTruthy()
  })
})
