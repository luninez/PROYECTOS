import mongoose, { Schema } from 'mongoose'

const donativoSchema = new Schema({
  cantidad: {
    type: String
  },
  usuario_id: {
    type: String
  },
  categoria_id: {
    type: String
  }
}, {
  timestamps: true,
  toJSON: {
    virtuals: true,
    transform: (obj, ret) => { delete ret._id }
  }
})

donativoSchema.methods = {
  view (full) {
    const view = {
      // simple view
      id: this.id,
      cantidad: this.cantidad,
      usuario_id: this.usuario_id,
      categoria_id: this.categoria_id,
      createdAt: this.createdAt,
      updatedAt: this.updatedAt
    }

    return full ? {
      ...view
      // add properties for a full view
    } : view
  }
}

const model = mongoose.model('Donativo', donativoSchema)

export const schema = model.schema
export default model
