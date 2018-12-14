import { Usuario } from '.'

let usuario

beforeEach(async () => {
  usuario = await Usuario.create({ token: 'test', nombre: 'test', email: 'test', password: 'test' })
})

describe('view', () => {
  it('returns simple view', () => {
    const view = usuario.view()
    expect(typeof view).toBe('object')
    expect(view.id).toBe(usuario.id)
    expect(view.token).toBe(usuario.token)
    expect(view.nombre).toBe(usuario.nombre)
    expect(view.email).toBe(usuario.email)
    expect(view.password).toBe(usuario.password)
    expect(view.createdAt).toBeTruthy()
    expect(view.updatedAt).toBeTruthy()
  })

  it('returns full view', () => {
    const view = usuario.view(true)
    expect(typeof view).toBe('object')
    expect(view.id).toBe(usuario.id)
    expect(view.token).toBe(usuario.token)
    expect(view.nombre).toBe(usuario.nombre)
    expect(view.email).toBe(usuario.email)
    expect(view.password).toBe(usuario.password)
    expect(view.createdAt).toBeTruthy()
    expect(view.updatedAt).toBeTruthy()
  })
})
