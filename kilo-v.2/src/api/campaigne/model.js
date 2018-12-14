import mongoose, { Schema } from 'mongoose'

const campaigneSchema = new Schema({
  nombre: {
    type: String
  },
  usuarios: {
    type: String
  },
  categorias: {
    type: String
  }
}, {
  timestamps: true,
  toJSON: {
    virtuals: true,
    transform: (obj, ret) => { delete ret._id }
  }
})

campaigneSchema.methods = {
  view (full) {
    const view = {
      // simple view
      id: this.id,
      nombre: this.nombre,
      usuarios: this.usuarios,
      categorias: this.categorias,
      createdAt: this.createdAt,
      updatedAt: this.updatedAt
    }

    return full ? {
      ...view
      // add properties for a full view
    } : view
  }
}

const model = mongoose.model('Campaigne', campaigneSchema)

export const schema = model.schema
export default model
