import mongoose, { Schema } from 'mongoose'

const categoriaSchema = new Schema({
  nombre: {
    type: String
  },
  campaigne_id: {
    type: String
  }
}, {
  timestamps: true,
  toJSON: {
    virtuals: true,
    transform: (obj, ret) => { delete ret._id }
  }
})

categoriaSchema.methods = {
  view (full) {
    const view = {
      // simple view
      id: this.id,
      nombre: this.nombre,
      campaigne_id: this.campaigne_id,
      createdAt: this.createdAt,
      updatedAt: this.updatedAt
    }

    return full ? {
      ...view
      // add properties for a full view
    } : view
  }
}

const model = mongoose.model('Categoria', categoriaSchema)

export const schema = model.schema
export default model
