import mongoose, { Schema } from 'mongoose'

const usuarioSchema = new Schema({
  token: {
    type: String
  },
  nombre: {
    type: String
  },
  email: {
    type: String
  },
  password: {
    type: String
  }
}, {
  timestamps: true,
  toJSON: {
    virtuals: true,
    transform: (obj, ret) => { delete ret._id }
  }
})

usuarioSchema.methods = {
  view (full) {
    const view = {
      // simple view
      id: this.id,
      token: this.token,
      nombre: this.nombre,
      email: this.email,
      password: this.password,
      createdAt: this.createdAt,
      updatedAt: this.updatedAt
    }

    return full ? {
      ...view
      // add properties for a full view
    } : view
  }
}

const model = mongoose.model('Usuario', usuarioSchema)

export const schema = model.schema
export default model
